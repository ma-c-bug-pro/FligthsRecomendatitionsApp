package com.example.flightsrecomendationsapp.data.network.networkmodel

import com.google.gson.annotations.SerializedName

data class Availability(
    @SerializedName("seats")
    val seats: Int?
)