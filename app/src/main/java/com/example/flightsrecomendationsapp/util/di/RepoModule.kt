package com.example.flightsrecomendationsapp.util

import com.example.flightsrecomendationsapp.data.repositories.FlightRepo
import org.koin.dsl.module

val RepoModule = module{
    factory { FlightRepo(get(), get()) }
}
