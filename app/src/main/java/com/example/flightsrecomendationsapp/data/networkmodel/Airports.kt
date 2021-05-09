package com.example.flightsrecomendationsapp.data.networkmodel

import com.google.gson.annotations.SerializedName

data class Airports(
        @SerializedName("filterName")
        val filterName: String,
        @SerializedName("name")
        val name: String
    )