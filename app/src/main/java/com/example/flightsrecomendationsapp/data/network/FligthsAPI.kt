package com.example.flightsrecomendationsapp.data.network

import com.example.flightsrecomendationsapp.data.networkmodel.SearchResult
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface FlightAPI {

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
        operator fun invoke(): FlightAPI {
            return Retrofit.Builder()
                .baseUrl("https://api.skypicker.com")
                .client(getInterceptor())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(FlightAPI::class.java)
        }


        private fun getInterceptor(): OkHttpClient {

            return OkHttpClient.Builder()
                .addInterceptor(getStaticQueryParametersInterceptor())
                .addInterceptor(getLoggingInterceptor())
                .build()
        }

        private fun getLoggingInterceptor(): Interceptor {
            return HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            }
        }

        /**
         * This interceptor is used to add values which are same for every call(v and partner),
         * but that shouldn't be hardcoded as partner can change and version too, but will remain same through one lifecycle of app,
         * but for the purpose of this task, it'll remain hardcoded. Should have some API which supplies this values.
         */
        private fun getStaticQueryParametersInterceptor(): Interceptor {
            return Interceptor { chain ->
                val original: Request = chain.request()
                val url = original.url
                val newUrl = url.newBuilder().addQueryParameter("v", "3")
                    .addQueryParameter("partner", "skypicker-android").build()
                val builder = original.newBuilder().url(newUrl)
                val request = builder.build()
                chain.proceed(request)
            }
        }
    }
}