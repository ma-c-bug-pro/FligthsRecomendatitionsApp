package com.example.flightsrecomendationsapp.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.flightsrecomendationsapp.data.publicmodel.FlightData

@Entity(tableName = "flight_data")
data class FlightDataEntity(
    @PrimaryKey(autoGenerate = false)
    override val id: String,
    override val flyFrom: String,
    override val flyTo: String,
    override val cityFrom: String,
    override val cityCodeFrom: String,
    override val cityTo: String,
    override val cityCodeTo: String,
    override val countryFrom: CountryEntity,
    override val countryTo: CountryEntity,
    override val dTime: Int,
    override val dTimeUTC: Int,
    override val aTime: Int,
    override val aTimeUTC: Int,
    val dateShown: String?

): FlightData()