package com.example.flightsrecomendationsapp.util

import java.text.SimpleDateFormat
import java.util.*

object DateFormatter {
    fun getDate(milliSeconds: Long, locale: Locale,  dateFormat: String? = "dd/MM/yyyy"): String {
        val formatter = SimpleDateFormat(dateFormat, locale )

        val calendar: Calendar = Calendar.getInstance()
        calendar.timeInMillis = milliSeconds
        return formatter.format(calendar.time)
    }
}