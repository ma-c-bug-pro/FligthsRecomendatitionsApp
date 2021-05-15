package com.example.flightsrecomendationsapp.data.db.entities

import androidx.room.Entity
import com.example.flightsrecomendationsapp.data.publicmodel.ICountryData

@Entity(tableName = "country_data")
data class CountryEntity(
    override val code: String,
    override val name: String
): ICountryData