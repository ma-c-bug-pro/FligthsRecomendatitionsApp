package com.example.flightsrecomendationsapp.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.flightsrecomendationsapp.data.networkmodel.SearchResult
import com.example.flightsrecomendationsapp.data.network.FlightAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FlightRepo {

    /**
     * Gets interesting popular flights
     */
    suspend fun getFlights(
        from: String,
        to: String,
        dateFrom: String,
        dateTo: String,
    ): LiveData<SearchResult?> {
        val flights = MutableLiveData<SearchResult?>()
        val response = FlightAPI().getInterestingFlights(from = from, to = to, dateFrom = dateFrom, dateTo = dateTo)
        withContext(Dispatchers.Main) {
            flights.value = response.body()
        }
        return flights
    }
}