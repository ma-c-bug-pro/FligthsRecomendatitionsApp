package com.example.flightsrecomendationsapp.util.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.flightsrecomendationsapp.ui.offersscreen.PopularOffersViewModel
import com.example.flightsrecomendationsapp.util.LocationUtil
import org.koin.dsl.bind
import org.koin.dsl.module

val AppModule = module {
    single { PopularOffersViewModel(get(), get()) }
    factory { LocationUtil() } bind LocationUtil::class
    single { provideAppPreferences(get()) } bind SharedPreferences::class
}

private fun provideAppPreferences(app: Application): SharedPreferences =
    app.getSharedPreferences("default_preferences", Context.MODE_PRIVATE)