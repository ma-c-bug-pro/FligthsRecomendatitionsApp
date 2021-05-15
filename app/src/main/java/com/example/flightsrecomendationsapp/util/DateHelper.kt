package com.example.flightsrecomendationsapp.util

import java.text.SimpleDateFormat
import java.util.*

object DateHelper {
    fun getDateAsString(milliSeconds: Long, locale: Locale, dateFormat: String? = "dd/MM/yyyy"): String {
        val formatter = SimpleDateFormat(dateFormat, locale )
        return formatter.format(Date(milliSeconds))
    }
    fun getDateAsStringS(seconds: Long, locale: Locale, dateFormat: String? = "dd/MM/yyyy"): String {
        val formatter = SimpleDateFormat(dateFormat, locale )
        return formatter.format(Date(seconds * 1000))
    }
    fun getDateAsString(date: Date, locale: Locale, dateFormat: String? = "dd/MM/yyyy"): String {
        val formatter = SimpleDateFormat(dateFormat, locale )
        return formatter.format(date.time)
    }

    fun getDateIncremented(date: String, locale: Locale, increment: Int): Date{
        val calendar: Calendar = Calendar.getInstance()
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + increment)
        return calendar.time
    }

    fun getDateIncrementedAsString(date: Date, locale: Locale, increment: Int, dateFormat: String = "dd/MM/yyyy"): String{
        val calendar: Calendar = Calendar.getInstance()
        calendar.timeInMillis = date.time
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + increment)
        return getDateAsString(calendar.time, locale, dateFormat)
    }

    fun getDateFromString(date: String, locale: Locale, dateFormat: String? = "dd/MM/yyyy"): Date {
        val formatter = SimpleDateFormat(dateFormat, locale)
        val formattedDate =  formatter.parse(date)
        return formattedDate?: throw Throwable("Invalid date format")
    }

    fun getCurrentDateTime(): Date {
        return Calendar.getInstance().time
    }
}