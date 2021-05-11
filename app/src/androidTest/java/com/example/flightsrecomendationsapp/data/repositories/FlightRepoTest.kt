package com.example.flightsrecomendationsapp.data.repositories

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class FlightRepoTest: KoinComponent {

    private val repo: FlightRepo by inject()

    @Before
    fun setUp() {
    }

    @Test
    fun getFlights() {
        runBlocking {
            val call = repo.getBestFlights("LON", "anywhere", "11/05/2021", "14/05/2021", "10/05/2021")
            call.collect {  println("Result: $it")
                println("Response count: ${it.data?.size}")
            }

        }
    }
}