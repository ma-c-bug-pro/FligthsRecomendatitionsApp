package com.example.flightsrecomendationsapp.data.repositories

import com.example.flightsrecomendationsapp.data.db.AppDatabase
import com.example.flightsrecomendationsapp.data.db.entities.FlightDataEntity
import com.example.flightsrecomendationsapp.data.network.api.FlightApi
import com.example.flightsrecomendationsapp.data.network.api.Resource
import com.example.flightsrecomendationsapp.data.network.networkmodel.FlightDataDto
import com.example.flightsrecomendationsapp.data.network.networkmodel.toEntity
import com.example.flightsrecomendationsapp.data.publicmodel.IFlightData
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
        currentDate: String = dateFrom
    ) = flow<Resource<List<IFlightData>?>> {
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
                    } && data.availability.seats != null && data.availability.seats > 0
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
                result = result?.filter { data ->
                    data.availability.seats != null && data.availability.seats > 0 && cachedIds?.contains(data.id) != true
                }
                result = result?.distinctBy {
                    it.cityCodeTo
                }?.take(5)
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