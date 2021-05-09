package com.example.flightsrecomendationsapp.data.network.networkmodel

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("code")
    val code: String,
    @SerializedName("name")
    val name: String
)