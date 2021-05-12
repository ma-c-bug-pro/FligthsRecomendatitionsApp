package com.example.flightsrecomendationsapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.flightsrecomendationsapp.data.db.entities.FlightDataEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FlightDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addFlights(flights: List<FlightDataEntity>)

    @Query("SELECT * FROM flight_data ORDER BY id ASC")
    suspend fun readAllFlights(): List<FlightDataEntity>?

    @Query("SELECT * FROM flight_data WHERE dateShown = :date ORDER BY id ASC")
    suspend fun readAllFlightsForDate(date: String): List<FlightDataEntity>?
}