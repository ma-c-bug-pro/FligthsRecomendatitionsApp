package com.example.flightsrecomendationsapp.util

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor

object ApiInterceptors {

    fun getLoggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
    }

    /**
     * This interceptor is used to add values which are same for every call(v and partner),
     * but that shouldn't be hardcoded as partner can change and version too, but will remain same through one lifecycle of app,
     * but for the purpose of this task, it'll remain hardcoded. Should have some API which supplies this values.
     */
    fun getStaticQueryParametersInterceptor(): Interceptor {
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