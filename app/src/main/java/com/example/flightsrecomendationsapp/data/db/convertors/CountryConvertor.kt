package com.example.flightsrecomendationsapp.data.db.convertors

import androidx.room.TypeConverter
import com.example.flightsrecomendationsapp.data.db.entities.CountryEntity

internal class CountryConvertor {
    @TypeConverter
    fun fromString(value: String?): CountryEntity? {
        val splited = value?.split(":")
        return if (!splited.isNullOrEmpty() && splited.size == 2)
            CountryEntity(splited[0], splited[1])
        else
            null
    }

    @TypeConverter
    fun fromCountryEntity(country: CountryEntity?): String {
        return "${country?.code}:${country?.name}"
    }
}