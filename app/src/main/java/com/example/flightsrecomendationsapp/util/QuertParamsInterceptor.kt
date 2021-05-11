package com.example.flightsrecomendationsapp.util

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * This interceptor is used to add values which are same for every call in this test app(v and partner)
 */
class QueryParamsInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original: Request = chain.request()
        val url = original.url
        val newUrl = url.newBuilder().addQueryParameter("v", "3")
            .addQueryParameter("partner", "skypicker-android").build()
        val builder = original.newBuilder().url(newUrl)
        val request = builder.build()
        return chain.proceed(request)
    }
}