package com.example.flightsrecomendationsapp.data.network.networkmodel

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("id")
    val id: String,
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
    @SerializedName("countryFrom")
    val countryFrom: Country,
    @SerializedName("countryTo")
    val countryTo: Country,
    @SerializedName("dTime")
    val dTime: Int,
    @SerializedName("dTimeUTC")
    val dTimeUTC: Int,
    @SerializedName("aTime")
    val aTime: Int,
    @SerializedName("aTimeUTC")
    val aTimeUTC: Int,
    @SerializedName("type_flights")
    val typeFlights: List<String>,
    @SerializedName("nightsInDest")
    val nightsInDest: Any?,
    @SerializedName("quality")
    val quality: Double,
    @SerializedName("popularity")
    val popularity: Int,
    @SerializedName("distance")
    val distance: Double,
    @SerializedName("duration")
    val duration: Duration,
    @SerializedName("fly_duration")
    val flyDuration: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("conversion")
    val conversion: Conversion,
    @SerializedName("discount_data")
    val discountData: DiscountData,
    @SerializedName("bags_price")
    val bagsPrice: BagsPrice,
    @SerializedName("baglimit")
    val baglimit: Baglimit,
    @SerializedName("availability")
    val availability: Availability,
    @SerializedName("routes")
    val routes: List<List<String>>,
    @SerializedName("airlines")
    val airlines: List<String>,
    @SerializedName("route")
    val route: List<Route>,
    @SerializedName("booking_token")
    val bookingToken: String,
    @SerializedName("deep_link")
    val deepLink: String,
    @SerializedName("tracking_pixel")
    val trackingPixel: String,
    @SerializedName("facilitated_booking_available")
    val facilitatedBookingAvailable: Boolean,
    @SerializedName("pnr_count")
    val pnrCount: Int,
    @SerializedName("has_airport_change")
    val hasAirportChange: Boolean,
    @SerializedName("technical_stops")
    val technicalStops: Int,
    @SerializedName("virtual_interlining")
    val virtualInterlining: Boolean,
    @SerializedName("mapIdfrom")
    val mapIdfrom: String,
    @SerializedName("mapIdto")
    val mapIdto: String,
    @SerializedName("hashtags")
    val hashtags: List<String>,
    @SerializedName("transfers")
    val transfers: List<Any>,
    @SerializedName("p1")
    val p1: Int,
    @SerializedName("p2")
    val p2: Int,
    @SerializedName("p3")
    val p3: Int
)