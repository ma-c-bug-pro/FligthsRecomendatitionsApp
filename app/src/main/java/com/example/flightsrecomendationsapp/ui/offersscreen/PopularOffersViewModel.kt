package com.example.flightsrecomendationsapp.ui.offersscreen

import android.app.Application
import android.os.Build
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.flightsrecomendationsapp.data.network.api.Resource
import com.example.flightsrecomendationsapp.data.publicmodel.IFlightData
import com.example.flightsrecomendationsapp.data.repositories.FlightRepo
import com.example.flightsrecomendationsapp.util.Coroutines
import com.example.flightsrecomendationsapp.util.DateHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.withContext
import java.util.*

class PopularOffersViewModel(private val app: Application, private val flightRepo: FlightRepo) :
    AndroidViewModel(app) {

    private var mutableFlightData: MutableLiveData<Resource<List<IFlightData>?>>? = MutableLiveData()
    var flightData: LiveData<Resource<List<IFlightData>?>>? = mutableFlightData
        private set

    fun getFlights(currentDate: Date, locationFrom: String, locationTo: String = "anywhere") {
        val locale: Locale = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            app.applicationContext.resources.configuration.locales[0]
        else
            app.applicationContext.resources.configuration.locale
        val date = DateHelper.getDateAsString(
            currentDate,
            locale
        )
        val incrementedDate = DateHelper.getDateIncrementedAsString(currentDate, locale, increment = 7)
        Coroutines.io {
            flightRepo.getBestFlights(
                from = locationFrom,
                to = locationTo,
                dateFrom = date,
                dateTo = incrementedDate
            ).collect {
                withContext(Dispatchers.Main) {
                    mutableFlightData?.value = it
                }
            }
//            flightData = flow.asLiveData(Dispatchers.Main)
        }
    }
}