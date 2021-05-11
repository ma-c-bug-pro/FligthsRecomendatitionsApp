package com.example.flightsrecomendationsapp.data.repositories

import com.example.flightsrecomendationsapp.data.db.AppDatabase
import com.example.flightsrecomendationsapp.data.network.api.FlightApi
import com.example.flightsrecomendationsapp.data.network.api.Resource
import com.example.flightsrecomendationsapp.data.network.networkmodel.Data
import kotlinx.coroutines.flow.collect
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
    ) = flow<Resource<List<Data>?>> {
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
        } else if (response.body() != null) {
            val localData = appDb.flightDao().readAllFlights()
            localData.collect {
                val cachedIds = it
                    ?.toMutableList()
                    ?.mapNotNull { data ->
                        if ((data.dateShown) == currentDate) null else data
                    }?.map { mapedData ->
                        mapedData.id
                    }
                val data = ArrayList<Data>().apply {
                    response.body()?.data?.toMutableList()?.removeAll { data ->
                        cachedIds?.contains(data.id) == true
                    }
                }
                emit(Resource.Success(data))
            }

        }
    }
}