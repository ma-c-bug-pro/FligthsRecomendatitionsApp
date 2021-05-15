package com.example.flightsrecomendationsapp.data.db.entities

import androidx.room.Entity
import com.example.flightsrecomendationsapp.data.publicmodel.IAvailabilityData

@Entity(tableName = "availability_data")
data class AvailabilityEntity(override val seats: Int?) : IAvailabilityData {
}