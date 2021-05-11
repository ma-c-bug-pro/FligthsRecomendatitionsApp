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
    suspend fun addFlights(flights: List<FlightDataEntity>)

    @Query("SELECT * FROM flight_data ORDER BY id ASC")
    fun readAllFlights(): Flow<List<FlightDataEntity>?>
}