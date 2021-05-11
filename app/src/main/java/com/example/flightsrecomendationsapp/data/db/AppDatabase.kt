package com.example.flightsrecomendationsapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.flightsrecomendationsapp.data.db.entities.FlightDataEntity

@Database(entities = [FlightDataEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun flightDao(): FlightDao

}