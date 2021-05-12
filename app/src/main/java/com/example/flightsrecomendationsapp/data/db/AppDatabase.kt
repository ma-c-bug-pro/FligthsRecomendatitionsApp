package com.example.flightsrecomendationsapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.flightsrecomendationsapp.data.db.convertors.CountryConvertor
import com.example.flightsrecomendationsapp.data.db.entities.FlightDataEntity

@Database(entities = [FlightDataEntity::class], version = 1, exportSchema = false)
@TypeConverters(CountryConvertor::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun flightDao(): FlightDao

}