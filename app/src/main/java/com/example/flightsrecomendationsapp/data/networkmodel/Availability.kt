package com.example.flightsrecomendationsapp.data.networkmodel

import com.google.gson.annotations.SerializedName

data class Availability(
    @SerializedName("seats")
    val seats: Int?
)