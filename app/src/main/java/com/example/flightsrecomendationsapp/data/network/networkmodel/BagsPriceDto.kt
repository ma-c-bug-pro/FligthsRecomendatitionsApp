package com.example.flightsrecomendationsapp.data.network.networkmodel

import com.google.gson.annotations.SerializedName

data class BagsPriceDto(
    @SerializedName("hand")
    val hand: Double,
    @SerializedName("1")
    val x1: Double,
    @SerializedName("2")
    val x2: Double
) {
    override fun toString(): String {
        return "[hand: $hand], [x1: $x1], [x2: $x2]"
    }
}