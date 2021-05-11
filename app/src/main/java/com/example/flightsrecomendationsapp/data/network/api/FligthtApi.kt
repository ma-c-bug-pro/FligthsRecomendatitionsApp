package com.example.flightsrecomendationsapp.data.network.api

import com.example.flightsrecomendationsapp.data.network.networkmodel.SearchResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FlightApi {

    @GET("/flights")
    suspend fun getInterestingFlights(
        @Query("flyFrom") from: String,
        @Query("to") to: String,
        @Query("dateFrom") dateFrom: String,
        @Query("dateTo") dateTo: String,
    ): Response<SearchResult>
}