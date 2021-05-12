package com.example.flightsrecomendationsapp.data.network.networkmodel

import com.google.gson.annotations.SerializedName

data class RouteDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("combination_id")
    val combinationId: String,
    @SerializedName("flyFrom")
    val flyFrom: String,
    @SerializedName("flyTo")
    val flyTo: String,
    @SerializedName("cityFrom")
    val cityFrom: String,
    @SerializedName("cityCodeFrom")
    val cityCodeFrom: String,
    @SerializedName("cityTo")
    val cityTo: String,
    @SerializedName("cityCodeTo")
    val cityCodeTo: String,
    @SerializedName("dTime")
    val dTime: Int,
    @SerializedName("dTimeUTC")
    val dTimeUTC: Int,
    @SerializedName("aTime")
    val aTime: Int,
    @SerializedName("aTimeUTC")
    val aTimeUTC: Int,
    @SerializedName("airline")
    val airline: String,
    @SerializedName("flight_no")
    val flightNo: Int,
    @SerializedName("operating_carrier")
    val operatingCarrier: String,
    @SerializedName("operating_flight_no")
    val operatingFlightNo: String,
    @SerializedName("fare_basis")
    val fareBasis: String,
    @SerializedName("fare_category")
    val fareCategory: String,
    @SerializedName("fare_classes")
    val fareClasses: String,
    @SerializedName("fare_family")
    val fareFamily: String,
    @SerializedName("return")
    val returnX: Int,
    @SerializedName("latFrom")
    val latFrom: Double,
    @SerializedName("lngFrom")
    val lngFrom: Double,
    @SerializedName("latTo")
    val latTo: Double,
    @SerializedName("lngTo")
    val lngTo: Double,
    @SerializedName("mapIdfrom")
    val mapIdfrom: String,
    @SerializedName("mapIdto")
    val mapIdto: String,
    @SerializedName("bags_recheck_required")
    val bagsRecheckRequired: Boolean,
    @SerializedName("guarantee")
    val guarantee: Boolean,
    @SerializedName("last_seen")
    val lastSeen: Int,
    @SerializedName("refresh_timestamp")
    val refreshTimestamp: Int,
    @SerializedName("equipment")
    val equipment: Any?,
    @SerializedName("vehicle_type")
    val vehicleType: String,
    @SerializedName("original_return")
    val originalReturn: Int,
    @SerializedName("source")
    val source: String,
    @SerializedName("found_on")
    val foundOn: String,
    @SerializedName("price")
    val price: Int
)