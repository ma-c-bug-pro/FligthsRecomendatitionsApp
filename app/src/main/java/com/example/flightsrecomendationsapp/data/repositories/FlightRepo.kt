package com.example.flightsrecomendationsapp.data.repositories

import com.example.flightsrecomendationsapp.data.db.AppDatabase
import com.example.flightsrecomendationsapp.data.db.entities.FlightDataEntity
import com.example.flightsrecomendationsapp.data.network.api.FlightApi
import com.example.flightsrecomendationsapp.data.network.api.Resource
import com.example.flightsrecomendationsapp.data.network.networkmodel.FlightDataDto
import com.example.flightsrecomendationsapp.data.network.networkmodel.toEntity
import com.example.flightsrecomendationsapp.data.publicmodel.FlightData
import kotlinx.coroutines.flow.flow

class FlightRepo(private val flightApi: FlightApi, private val appDb: AppDatabase) {

    /**
     * Gets interesting popular flights
     */
    suspend fun getBestFlights(
        from: String,
        to: String,
        dateFrom: String,
        dateTo: String,
        currentDate: String
    ) = flow<Resource<List<FlightData>?>> {
        emit(Resource.Loading())
        val response = flightApi.getInterestingFlights(
            from = from,
            to = to,
            dateFrom = dateFrom,
            dateTo = dateTo
        )
        if (!response.isSuccessful) {
            emit(
                Resource.Error(
                    message = response.errorBody()?.string() ?: "Couldn't retrieve data"
                )
            )
        } else {
            val responseData = response.body()?.data
            var result: List<FlightDataDto>?
            var localData: List<FlightDataEntity?>? =
                appDb.flightDao().readAllFlightsForDate(currentDate)
            if (localData != null && localData.size >= 5) {
                result = responseData?.filter { data ->
                    data.id in localData!!.map {
                        it?.id
                    }
                }
            } else {
                localData = appDb.flightDao().readAllFlights()
                val cachedIds = localData
                    ?.toMutableList()
                    ?.mapNotNull { data ->
                        if ((data.dateShown) == currentDate) null else data
                    }?.map { mapedData ->
                        mapedData.id
                    }
                result = responseData?.toMutableList()
                result?.toMutableList()?.removeAll { data ->
                        cachedIds?.contains(data.id) == true
                    }
                result = result?.take(5)

            }
            emit(Resource.Success(result?.map {
                it
            }))
            saveShownFlights(result?.map {
                it.toEntity(currentDate)
            })
        }
    }

    private fun saveShownFlights(flights: List<FlightDataEntity>?) {
        if (!flights.isNullOrEmpty()){
            appDb.flightDao().addFlights(flights)
        }
    }
}