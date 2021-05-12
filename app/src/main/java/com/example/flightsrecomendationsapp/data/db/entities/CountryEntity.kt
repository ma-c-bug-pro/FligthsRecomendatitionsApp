package com.example.flightsrecomendationsapp.data.db.entities

import com.example.flightsrecomendationsapp.data.publicmodel.CountryData

data class CountryEntity(
    override val code: String,
    override val name: String
):CountryData()