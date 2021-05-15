package com.example.flightsrecomendationsapp.ui.offersscreen

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.flightsrecomendationsapp.data.publicmodel.IFlightData
import com.example.flightsrecomendationsapp.databinding.FragmentOfferHolderBinding
import com.example.flightsrecomendationsapp.util.DateHelper

class OfferHolderFragment(private val data: IFlightData) : Fragment() {

    private lateinit var binding: FragmentOfferHolderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOfferHolderBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.priceText.text = data.price.toString()
        binding.seatsText.text = "${(data.availability.seats ?: 0)}"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            binding.departureTimeText.text = DateHelper.getDateAsStringS(data.dTime, requireContext().resources.configuration.locales[0])
            binding.arrivalTimeText.text = DateHelper.getDateAsStringS(data.aTime, requireContext().resources.configuration.locales[0])
        } else {
            binding.departureTimeText.text = DateHelper.getDateAsStringS(data.dTime, requireContext().resources.configuration.locale)
            binding.arrivalTimeText.text = DateHelper.getDateAsStringS(data.aTime, requireContext().resources.configuration.locale)
        }
        binding.fromText.text = data.cityFrom
        binding.destinationText.text = data.cityTo
        binding.distanceText.text = data.distance.toString()
        binding.flyDurationText.text = data.flyDuration
        Glide.with(requireContext())
            .load("https://images.kiwi.com/photos/600x600/${data.mapIdto}.jpg")
            .into(binding.destinationImage)
    }

}