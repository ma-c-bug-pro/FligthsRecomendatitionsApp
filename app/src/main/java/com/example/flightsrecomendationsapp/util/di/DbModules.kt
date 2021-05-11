package com.example.flightsrecomendationsapp.util

import androidx.room.Room
import com.example.flightsrecomendationsapp.data.db.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val DbModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "app_database"
        ).build()
    }
}