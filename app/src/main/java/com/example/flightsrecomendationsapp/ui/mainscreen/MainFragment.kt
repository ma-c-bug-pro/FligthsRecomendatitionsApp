package com.example.flightsrecomendationsapp.ui.mainscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.flightsrecomendationsapp.data.repositories.FlightRepo
import com.example.flightsrecomendationsapp.databinding.FragmentMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private val repo: FlightRepo by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        GlobalScope.launch {
            val call =
                repo.getBestFlights("LON", "anywhere", "11/05/2021", "14/05/2021", "10/05/2021")
            call.collect {
                println("Result: $it")
                println("Response count: ${it.data?.size}")
            }
        }
    }
}