package com.example.flightsrecomendationsapp.data.network.networkmodel


import com.google.gson.annotations.SerializedName

data class SearchResult(
    @SerializedName("search_id")
    val searchId: String,
    @SerializedName("time")
    val time: Int,
    @SerializedName("currency")
    val currency: String,
    @SerializedName("fx_rate")
    val fxRate: Int,
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("_results")
    val results: Int,
    @SerializedName("best_results")
    val bestResults: List<Any>,
    @SerializedName("search_params")
    val searchParams: SearchParams,
    @SerializedName("hashtags")
    val hashtags: List<Hashtag>,
    @SerializedName("location_hashtags")
    val locationHashtags: List<String>,
    @SerializedName("airlinesList")
    val airlinesList: List<Any>,
    @SerializedName("airportsList")
    val airportsList: List<Airports>,
    @SerializedName("all_airlines")
    val allAirlines: List<Any>,
    @SerializedName("all_stopover_airports")
    val allStopoverAirports: List<String>,
    @SerializedName("all_stopover_countries")
    val allStopoverCountries: List<String>,
    @SerializedName("all_prices")
    val allPrices: AllPrices,
    @SerializedName("del")
    val del: Int,
    @SerializedName("currency_rate")
    val currencyRate: Int,
    @SerializedName("connections")
    val connections: List<Any>,
    @SerializedName("refresh")
    val refresh: List<Any>,
    @SerializedName("ref_tasks")
    val refTasks: List<Any>
)