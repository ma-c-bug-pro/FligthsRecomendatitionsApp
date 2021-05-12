package com.example.flightsrecomendationsapp.data.repositories

import android.content.Context
import com.example.flightsrecomendationsapp.data.db.entities.FlightDataEntity
import com.example.flightsrecomendationsapp.data.network.api.Resource
import com.example.flightsrecomendationsapp.util.DateFormatter
import com.google.gson.Gson
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.util.*

class FlightRepoTest: KoinComponent {

    private val repo: FlightRepo by inject()

    private val context: Context by inject()

    @Before
    fun setUp() {
    }

    @Test
    fun getFlights() {
        runBlocking {
            val gson = Gson()
            val call = repo.getBestFlights("LON", "anywhere", "11/05/2021", "14/05/2021", DateFormatter.getDate(milliSeconds = System.currentTimeMillis(), locale =  context.resources.configuration.locales[0]))
            call.collect {  println("Result: $it")
                println("Response count: ${it.data?.size}")
                if(it is Resource.Success && !it.data.isNullOrEmpty()) {
                    println("Decoded entity: ${it.data}")
                }
            }

        }
    }
}