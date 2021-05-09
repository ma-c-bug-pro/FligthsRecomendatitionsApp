package com.example.flightsrecomendationsapp.data.repositories

import android.util.Log
import com.example.flightsrecomendationsapp.data.network.FlightAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class FlightRepoTest {

    private lateinit var repo: FlightRepo

    @Before
    fun setUp() {
        repo = FlightRepo()
    }

    @Test
    fun getFlights() {
        runBlocking {
            val call = repo.getFlights("LON", "anywhere", "10/05/2021", "11/05/2021")
            call.value?.let { println("Result: $it")}
            val value = call.value
            println("Response count: ${value?.data?.size}")
        }
    }
}