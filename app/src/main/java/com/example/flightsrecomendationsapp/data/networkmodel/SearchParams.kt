package com.example.flightsrecomendationsapp.data.networkmodel

import com.google.gson.annotations.SerializedName

data class SearchParams(
    @SerializedName("flyFrom_type")
    val flyFromType: String,
    @SerializedName("to_type")
    val toType: String,
    @SerializedName("seats")
    val seats: Seats
)