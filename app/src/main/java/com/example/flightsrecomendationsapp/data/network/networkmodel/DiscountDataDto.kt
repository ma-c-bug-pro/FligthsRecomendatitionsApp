package com.example.flightsrecomendationsapp.data.network.networkmodel

import com.google.gson.annotations.SerializedName

data class DiscountDataDto(
    @SerializedName("original_price")
    val originalPrice: Int
)