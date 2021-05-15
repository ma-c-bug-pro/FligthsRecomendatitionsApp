package com.example.flightsrecomendationsapp.util

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Build
import android.os.Looper
import android.provider.Settings
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlin.math.pow
import kotlin.math.round


class LocationUtil {

    private lateinit var callback: ActivityResultLauncher<String>

    private val responseFlow = MutableSharedFlow<Boolean>()

    private var onPermissionResult: (result: Boolean) -> Unit = { }

    private lateinit var mFragment: Fragment

    fun registerForActivityResult(
        fragment: Fragment
    ) {
        mFragment = fragment
        callback =
            mFragment.registerForActivityResult(ActivityResultContracts.RequestPermission()) { pResult ->
                onPermissionResult(pResult)
            }
    }

    fun checkPermissions(permission: String): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ContextCompat.checkSelfPermission(
                mFragment.requireContext(),
                permission
            ) == PackageManager.PERMISSION_GRANTED
        } else {
            ActivityCompat.checkSelfPermission(
                mFragment.requireContext(),
                permission
            ) == PackageManager.PERMISSION_GRANTED
        }
    }

    fun requestPermission(permission: String, onResult: (result: Boolean) -> Unit) {
        if (!checkPermissions(permission)) {
            onPermissionResult = onResult
            callback.launch(permission)
        }
    }

    @SuppressLint("MissingPermission")
    fun requestNewLocationData(
        client: FusedLocationProviderClient,
        locationCallback: (lat: Double, lon: Double) -> Unit
    ) {
        val mLocationRequest = LocationRequest()
        mLocationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        mLocationRequest.interval = 5
        mLocationRequest.fastestInterval = 0
        mLocationRequest.numUpdates = 1

        // setting LocationRequest
        // on FusedLocationClient
        client.requestLocationUpdates(
            mLocationRequest,
            object : LocationCallback() {
                override fun onLocationResult(locationResult: LocationResult) {
                    locationCallback(
                        locationResult.lastLocation.latitude,
                        locationResult.lastLocation.longitude
                    )
                }
            },
            Looper.myLooper()
        )
    }

    fun isLocationEnabled(activity: Activity): Boolean {
        val locationManager =
            activity.getSystemService(Context.LOCATION_SERVICE) as LocationManager?
        return (locationManager?.isProviderEnabled(LocationManager.GPS_PROVIDER) == true
                || locationManager?.isProviderEnabled(LocationManager.NETWORK_PROVIDER) == true)
    }

    fun enableLocationSource(activity: Activity) {
        val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
        activity.startActivity(intent)
    }

    companion object {
        fun Double.roundToXDecimalPlaces(x: Int): Double {
            return  round((this * 10.0.pow(x.toDouble()))) / (10.0.pow(x.toDouble()))
        }
    }
}