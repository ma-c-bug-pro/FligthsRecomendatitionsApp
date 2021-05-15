package com.example.flightsrecomendationsapp.data.network.networkmodel

import com.example.flightsrecomendationsapp.data.db.entities.FlightDataEntity
import com.example.flightsrecomendationsapp.data.publicmodel.IFlightData
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
    override val dTime: Long,
     @SerializedName("dTimeUTC")
    override val dTimeUTC: Long,
     @SerializedName("aTime")
    override val aTime: Long,
     @SerializedName("aTimeUTC")
    override val aTimeUTC: Long,
     @SerializedName("type_flights")
    val typeFlights: List<String>,
     @SerializedName("nightsInDest")
    override val nightsInDest: Int?,
     @SerializedName("quality")
    override val quality: Double,
     @SerializedName("popularity")
    override val popularity: Int,
     @SerializedName("distance")
    override val distance: Double,
     @SerializedName("duration")
    val duration: DurationDto,
     @SerializedName("fly_duration")
    override val flyDuration: String,
     @SerializedName("price")
    override val price: Int,
     @SerializedName("conversion")
    val conversion: ConversionDto,
     @SerializedName("bags_price")
    override val bagsPrice: BagsPriceDto,
     @SerializedName("baglimit")
    val baglimit: BaglimitDto,
     @SerializedName("availability")
    override val availability: AvailabilityDto,
//    @SerializedName("routes")
//    val routes: List<List<RouteDto>>,
     @SerializedName("airlines")
    val airlines: List<String>,
     @SerializedName("booking_token")
    override val bookingToken: String,
     @SerializedName("deep_link")
    override val deepLink: String,
     @SerializedName("tracking_pixel")
    override val trackingPixel: String,
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
     override val mapIdfrom: String,
     @SerializedName("mapIdto")
     override val mapIdto: String,
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
) : IFlightData

internal fun FlightDataDto.toEntity(dateShown: String): FlightDataEntity {
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
        nightsInDest ?: 0,
        quality,
        popularity,
        distance,
        flyDuration,
        price,
        bagsPrice.toString(),
        availability.toEntity(),
        bookingToken,
        deepLink,
        trackingPixel,
        mapIdfrom,
        mapIdto,
        dateShown
    )
}

