package com.example.flightsrecomendationsapp.util

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.flightsrecomendationsapp.R

class PermissionFragmentDialog(val allowPermission: () -> Unit,
                               val declinePermission: () -> Unit,
                               val declineForeverPermission: () -> Unit) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setMessage(getString(R.string.requiredLocationPermissionsText))
            .setPositiveButton(R.string.requestPermission) { _, _ ->
                allowPermission()
            }
            .setNegativeButton(R.string.declinePermission) { _, _ ->
                declinePermission()
            }
            .setNeutralButton(R.string.neverAskAgainLocation) { _, _ ->
                declineForeverPermission()
            }
            .create()
}