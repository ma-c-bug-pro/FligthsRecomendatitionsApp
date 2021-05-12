package com.example.flightsrecomendationsapp.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "flight_data")
data class FlightDataEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val flyFrom: String,
    val flyTo: String,
    val cityFrom: String,
    val cityCodeFrom: String,
    val cityTo: String,
    val cityCodeTo: String,
    val countryFrom: String,
    val countryTo: String,
    val dTime: Int,
    val dTimeUTC: Int,
    val aTime: Int,
    val aTimeUTC: Int,
    val dateShown: String?

)