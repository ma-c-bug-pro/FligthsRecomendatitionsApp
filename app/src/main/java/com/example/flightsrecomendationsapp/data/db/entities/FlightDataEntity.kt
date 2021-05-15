package com.example.flightsrecomendationsapp.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.flightsrecomendationsapp.data.publicmodel.IFlightData

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
    override val dTime: Long,
    override val dTimeUTC: Long,
    override val aTime: Long,
    override val aTimeUTC: Long,
    override val nightsInDest: Int?,
    override val quality: Double,
    override val popularity: Int,
    override val distance: Double,
    override val flyDuration: String,
    override val price: Int,
    override val bagsPrice: String,
    override val availability: AvailabilityEntity,
    override val bookingToken: String,
    override val deepLink: String,
    override val trackingPixel: String,
    override val mapIdfrom: String,
    override val mapIdto: String,
    val dateShown: String?

    ) : IFlightData