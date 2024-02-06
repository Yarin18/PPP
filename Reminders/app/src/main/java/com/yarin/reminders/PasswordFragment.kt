package com.yarin.reminders

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.yarin.reminders.databinding.DialogEditReminderBinding
import com.yarin.reminders.databinding.FragmentPasswordsBinding

class PasswordFragment : Fragment() {

    private lateinit var binding: FragmentPasswordsBinding
    private val preferences by lazy {
        requireActivity().getSharedPreferences(
            "passwords",
            Context.MODE_PRIVATE
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPasswordsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayValues()
        binding.cardViewWifi.setOnClickListener { showEditDialog(PREF_WIFI) }
        binding.cardViewTabletPin.setOnClickListener { showEditDialog(PREF_TABLET_PIN) }
        binding.cardViewBikeLock.setOnClickListener { showEditDialog(PREF_BIKE_LOCK) }
    }

    private fun displayValues() {
        binding.textViewWifiValue.text = preferences.getString(PREF_WIFI, null)
        binding.textViewTabletPinValue.text = preferences.getString(PREF_TABLET_PIN, null)
        binding.textViewBikeLockValue.text = preferences.getString(PREF_BIKE_LOCK, null)
    }

    private fun showEditDialog(preference: String) {
        val dialogBinding = DialogEditReminderBinding.inflate(requireActivity().layoutInflater)

        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Update Value")
            .setView(dialogBinding.root)
            .setPositiveButton("Save") { _, _ ->
                preferences.edit().putString(preference, dialogBinding.editTextValue.text.toString()).apply()
                displayValues()
            }
            .setNegativeButton("Cancel") { _, _ ->


            }.show()
    }

    companion object {
        const val PREF_WIFI = "pref_wifi"
        const val PREF_TABLET_PIN = "pref_tablet_pin"
        const val PREF_BIKE_LOCK = "pref_bike_lock"
    }

}