package com.example.flightsrecomendationsapp.data.publicmodel

interface IFlightData {
    val id: String
    val flyFrom: String
    val flyTo: String
    val cityFrom: String
    val cityCodeFrom: String
    val cityTo: String
    val cityCodeTo: String
    val countryFrom: ICountryData
    val countryTo: ICountryData
    val dTime: Long
    val dTimeUTC: Long
    val aTime: Long
    val aTimeUTC: Long
    val nightsInDest: Int?
    val quality: Double
    val popularity: Int
    val distance: Double
    val flyDuration: String
    val price: Int
    val bagsPrice: Any
    val availability: IAvailabilityData
    val bookingToken: String
    val deepLink: String
    val trackingPixel: String
    val mapIdfrom: String
    val mapIdto: String
}