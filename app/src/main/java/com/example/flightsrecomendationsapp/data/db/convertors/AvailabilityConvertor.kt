package com.example.flightsrecomendationsapp.data.db.convertors

import androidx.room.TypeConverter
import com.example.flightsrecomendationsapp.data.db.entities.AvailabilityEntity


internal class AvailabilityConvertor {
    @TypeConverter
    fun fromString(value: String?): AvailabilityEntity {
        return AvailabilityEntity((value?: "0").toInt())
    }

    @TypeConverter
    fun fromCountryEntity(value: AvailabilityEntity): String {
        return (value.seats ?: 0).toString()
    }
}