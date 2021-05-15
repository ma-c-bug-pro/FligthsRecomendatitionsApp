package com.example.flightsrecomendationsapp.data.network.networkmodel

import com.example.flightsrecomendationsapp.data.db.entities.AvailabilityEntity
import com.example.flightsrecomendationsapp.data.publicmodel.IAvailabilityData
import com.google.gson.annotations.SerializedName

data class AvailabilityDto(
    @SerializedName("seats")
    override val seats: Int?
) : IAvailabilityData {

    fun toEntity(): AvailabilityEntity {
        return AvailabilityEntity(seats)
    }
}