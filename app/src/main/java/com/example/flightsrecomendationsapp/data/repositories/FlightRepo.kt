package com.example.flightsrecomendationsapp.data.repositories

import com.example.flightsrecomendationsapp.data.network.networkmodel.SearchResult
import com.example.flightsrecomendationsapp.data.network.api.FlightApi
import com.example.flightsrecomendationsapp.util.Coroutines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.withContext

class FlightRepo {

    /**
     * Gets interesting popular flights
     */
    fun getFlights(
        from: String,
        to: String,
        dateFrom: String,
        dateTo: String,
    ): Flow<SearchResult?> {
        val flights = MutableStateFlow<SearchResult?>(null)
        Coroutines.io {
            val response = FlightApi().getInterestingFlights(
                from = from,
                to = to,
                dateFrom = dateFrom,
                dateTo = dateTo
            )
            withContext(Dispatchers.Main) {
                flights.value = response.body()
            }
        }
        return flights.asStateFlow()
    }
}