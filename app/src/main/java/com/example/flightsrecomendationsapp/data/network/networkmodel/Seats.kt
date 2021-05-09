package com.example.flightsrecomendationsapp.data.network.networkmodel

import com.google.gson.annotations.SerializedName

data class Seats(
            @SerializedName("passengers")
            val passengers: Int,
            @SerializedName("adults")
            val adults: Int,
            @SerializedName("children")
            val children: Int,
            @SerializedName("infants")
            val infants: Int
        )