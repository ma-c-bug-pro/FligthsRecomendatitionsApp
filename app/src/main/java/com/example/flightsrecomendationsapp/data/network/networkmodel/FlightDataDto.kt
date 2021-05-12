package com.example.flightsrecomendationsapp.data.network.networkmodel

import com.example.flightsrecomendationsapp.data.db.entities.FlightDataEntity
import com.example.flightsrecomendationsapp.data.publicmodel.FlightData
import com.google.gson.annotations.SerializedName

data class FlightDataDto(
    @SerializedName("id")
    override val id: String,
    @SerializedName("flyFrom")
    override val flyFrom: String,
    @SerializedName("flyTo")
    override val flyTo: String,
    @SerializedName("cityFrom")
    override val cityFrom: String,
    @SerializedName("cityCodeFrom")
    override val cityCodeFrom: String,
    @SerializedName("cityTo")
    override val cityTo: String,
    @SerializedName("cityCodeTo")
    override val cityCodeTo: String,
    @SerializedName("countryFrom")
    override val countryFrom: CountryDto,
    @SerializedName("countryTo")
    override val countryTo: CountryDto,
    @SerializedName("dTime")
    override val dTime: Int,
    @SerializedName("dTimeUTC")
    override val dTimeUTC: Int,
    @SerializedName("aTime")
    override val aTime: Int,
    @SerializedName("aTimeUTC")
    override val aTimeUTC: Int,
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
    val duration: DurationDto,
    @SerializedName("fly_duration")
    val flyDuration: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("conversion")
    val conversion: ConversionDto,
    @SerializedName("discount_data")
    val discountData: DiscountDataDto,
    @SerializedName("bags_price")
    val bagsPrice: BagsPriceDto,
    @SerializedName("baglimit")
    val baglimit: BaglimitDto,
    @SerializedName("availability")
    val availability: AvailabilityDto,
    @SerializedName("routes")
    val routes: List<List<String>>,
    @SerializedName("airlines")
    val airlines: List<String>,
    @SerializedName("route")
    val route: List<RouteDto>,
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
): FlightData()

fun FlightDataDto.toEntity(dateShown: String): FlightDataEntity {
    return FlightDataEntity(
        id,
        flyFrom,
        flyTo,
        cityFrom,
        cityCodeFrom,
        cityTo,
        cityCodeTo,
        countryFrom.toEntity(),
        countryTo.toEntity(),
        dTime,
        dTimeUTC,
        aTime,
        aTimeUTC,
        dateShown
    )
}

