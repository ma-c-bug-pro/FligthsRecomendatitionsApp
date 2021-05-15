package com.example.flightsrecomendationsapp.data.network.networkmodel

import com.example.flightsrecomendationsapp.data.db.entities.CountryEntity
import com.example.flightsrecomendationsapp.data.publicmodel.ICountryData
import com.google.gson.annotations.SerializedName

data class CountryDto(
    @SerializedName("code")
    override val code: String,
    @SerializedName("name")
    override val name: String
) : ICountryData

internal fun CountryDto.toEntity(): CountryEntity {
    return CountryEntity(code, name)
}