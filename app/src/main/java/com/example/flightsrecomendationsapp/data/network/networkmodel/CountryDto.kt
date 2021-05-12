package com.example.flightsrecomendationsapp.data.network.networkmodel

import com.example.flightsrecomendationsapp.data.db.entities.CountryEntity
import com.example.flightsrecomendationsapp.data.publicmodel.CountryData
import com.google.gson.annotations.SerializedName

data class CountryDto(
    @SerializedName("code")
    override val code: String,
    @SerializedName("name")
    override val name: String
):CountryData()

fun CountryDto.toEntity():CountryEntity {
    return CountryEntity(code, name)
}