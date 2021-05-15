package com.example.flightsrecomendationsapp.ui.mainscreen

import android.Manifest
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.flightsrecomendationsapp.databinding.FragmentMainBinding
import com.example.flightsrecomendationsapp.util.LocationUtil
import com.example.flightsrecomendationsapp.util.LocationUtil.Companion.roundToXDecimalPlaces
import com.example.flightsrecomendationsapp.util.PermissionFragmentDialog
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import org.koin.android.ext.android.inject


class MainFragment : Fragment() {

    private lateinit var mFusedLocationClient: FusedLocationProviderClient

    private lateinit var binding: FragmentMainBinding

    private val locationUtil: LocationUtil by inject()

    private val appPrefs: SharedPreferences by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        locationUtil.registerForActivityResult(this@MainFragment)
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
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
        binding.getNearestBtn.setOnClickListener{
            checkNeededPermissions()
        }
    }

    private fun checkNeededPermissions() {
        if (!locationUtil.checkPermissions(
                Manifest.permission.ACCESS_FINE_LOCATION,
            ) && appPrefs.getBoolean("ask_loc_permissions", true)
        ) {
            showPermissionDialog()
        } else {
            goToOffersFragment()
        }
    }

    private fun goToOffersFragment() {

        if (locationUtil.isLocationEnabled(requireActivity())) {
            var location = ""
            locationUtil.requestNewLocationData(mFusedLocationClient) { lat, lon ->
                location = "${lat.roundToXDecimalPlaces(2)}-${lon.roundToXDecimalPlaces(2)}-250km"
                val action = MainFragmentDirections.actionMainFragmentToPopularOfferFragment(location)
                findNavController().navigate(action)
            }

        } else {
            locationUtil.enableLocationSource(requireActivity())
        }
    }

    private fun showPermissionDialog() {
        if (!locationUtil.checkPermissions(
                Manifest.permission.ACCESS_FINE_LOCATION,
            )
        ) {
            PermissionFragmentDialog(allowPermission = {
                locationUtil.requestPermission(
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) {
                    goToOffersFragment()
                }
            },
                declinePermission = {

                },
                declineForeverPermission = {
                    appPrefs.edit().putBoolean("ask_loc_permissions", false).apply()
                }).show(childFragmentManager, "permission_dialog_fragment")
        }
    }
}
