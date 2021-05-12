package com.example.flightsrecomendationsapp.data.publicmodel

open class FlightData {
    @Transient
    open val id: String = ""
    @Transient
    open val flyFrom: String = ""
    @Transient
    open val flyTo: String = ""
    @Transient
    open val cityFrom: String = ""
    @Transient
    open val cityCodeFrom: String = ""
    @Transient
    open val cityTo: String = ""
    @Transient
    open val cityCodeTo: String = ""
    @Transient
    open val countryFrom: CountryData = CountryData()
    @Transient
    open val countryTo: CountryData = CountryData()
    @Transient
    open val dTime: Int = 0
    @Transient
    open val dTimeUTC: Int = 0
    @Transient
    open val aTime: Int = 0
    @Transient
    open val aTimeUTC: Int = 0
}