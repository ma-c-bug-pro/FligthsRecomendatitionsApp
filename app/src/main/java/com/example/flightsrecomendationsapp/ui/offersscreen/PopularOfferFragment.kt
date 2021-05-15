package com.example.flightsrecomendationsapp.ui.offersscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.flightsrecomendationsapp.R
import com.example.flightsrecomendationsapp.data.network.api.Resource
import com.example.flightsrecomendationsapp.databinding.FragmentPopularOfferBinding
import com.example.flightsrecomendationsapp.util.DateHelper
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.android.ext.android.inject


class PopularOfferFragment : Fragment() {

    private lateinit var binding: FragmentPopularOfferBinding
    private val args: PopularOfferFragmentArgs by navArgs()
    private val viewModel: PopularOffersViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPopularOfferBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val location = args.location
        val adapter = PopularOfferPagerAdapter(requireActivity().supportFragmentManager, lifecycle)
        binding.mainPager.adapter = adapter
        TabLayoutMediator(binding.mainTabLayout, binding.mainPager) { tab, position ->
        }.attach()
        viewModel.getFlights(DateHelper.getCurrentDateTime(), locationFrom = location)
        viewModel.flightData?.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                    startLoading()
                }
                is Resource.Error -> {
                    showError(it.message)
                }
                else -> {
                    if (it.data != null)
                        for (item in it.data) {
                            val fragment = OfferHolderFragment(item)
                            adapter.addFragment(fragment)
                        }
                    showData()
                }
            }
        }
    }

    private fun showData() {
        binding.loadingErrorLayout.visibility = View.GONE
    }

    private fun showError(error: String?) {
        binding.loadingIndicator.visibility = View.GONE
        binding.errorText.visibility = View.VISIBLE
        binding.errorText.text = error ?: getString(R.string.generic_error_text)
    }

    private fun startLoading() {
        binding.loadingErrorLayout.visibility = View.VISIBLE
    }
}