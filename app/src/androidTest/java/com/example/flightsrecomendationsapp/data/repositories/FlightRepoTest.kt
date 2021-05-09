package com.example.flightsrecomendationsapp.data.repositories

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
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
            call.collect {  println("Result: $it")
                println("Response count: ${it?.data?.size}")
            }

        }
    }
}