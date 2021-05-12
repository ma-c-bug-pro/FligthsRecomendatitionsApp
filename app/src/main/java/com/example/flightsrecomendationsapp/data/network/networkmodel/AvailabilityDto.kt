package com.example.flightsrecomendationsapp.data.network.networkmodel

import com.google.gson.annotations.SerializedName

data class AvailabilityDto(
    @SerializedName("seats")
    val seats: Int?
)