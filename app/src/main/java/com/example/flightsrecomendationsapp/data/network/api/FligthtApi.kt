package com.example.flightsrecomendationsapp.data.network.api

import com.example.flightsrecomendationsapp.data.network.networkmodel.SearchResult
import com.example.flightsrecomendationsapp.util.ApiInterceptors.getLoggingInterceptor
import com.example.flightsrecomendationsapp.util.ApiInterceptors.getStaticQueryParametersInterceptor
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface FlightApi {

    //ToDo add partner and sort as
    @GET("/flights")
    suspend fun getInterestingFlights(
//        @Query("v") version: String = "3",
        @Query("flyFrom") from: String,
        @Query("to") to: String,
        @Query("dateFrom") dateFrom: String,
        @Query("dateTo") dateTo: String,
//        @Query("partner") partner: String = "skypicker-android"
    ): Response<SearchResult>

    companion object {
        operator fun invoke(): FlightApi {
            return Retrofit.Builder()
                .baseUrl("https://api.skypicker.com")
                .client(getInterceptor())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(FlightApi::class.java)
        }


        private fun getInterceptor(): OkHttpClient {
            return OkHttpClient.Builder()
                .addInterceptor(getStaticQueryParametersInterceptor())
                .addInterceptor(getLoggingInterceptor())
                .build()
        }


    }
}