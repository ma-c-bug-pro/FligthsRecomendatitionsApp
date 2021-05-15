package com.example.flightsrecomendationsapp.ui

import android.app.Application
import com.example.flightsrecomendationsapp.util.DbModule
import com.example.flightsrecomendationsapp.util.NetworkModule
import com.example.flightsrecomendationsapp.util.RepoModule
import com.example.flightsrecomendationsapp.util.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(applicationContext)
            modules(
                listOf(
                    NetworkModule,
                    DbModule,
                    RepoModule,
                    AppModule
                )
            )
        }

    }
}