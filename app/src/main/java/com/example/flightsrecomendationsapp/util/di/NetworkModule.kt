package com.example.flightsrecomendationsapp.util

import com.example.flightsrecomendationsapp.data.network.api.FlightApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val NetworkModule = module {
    factory { getLoggingInterceptor() } bind HttpLoggingInterceptor::class
    factory { QueryParamsInterceptor() } bind QueryParamsInterceptor::class
    factory { getHttpClient(listOf(get<QueryParamsInterceptor>(), get<HttpLoggingInterceptor>())) }
    single(createdAtStart = true) { retrofitInstance(get()) }
    single { get<Retrofit>().create(FlightApi::class.java) }
}

const val BASE_URL = "https://api.skypicker.com"

fun retrofitInstance(client: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
}

fun getHttpClient(interceptors: List<Interceptor>): OkHttpClient {
    val client = OkHttpClient.Builder()
    for (interceptor in interceptors)
        client.addInterceptor(interceptor)
    return client.build()
}

fun getLoggingInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }
}


