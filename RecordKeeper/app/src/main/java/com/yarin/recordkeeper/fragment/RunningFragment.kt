package com.yarin.recordkeeper.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yarin.recordkeeper.EditActivityRecord
import com.yarin.recordkeeper.databinding.FragmentRunningBinding

class RunningFragment : Fragment() {

    private lateinit var binding: FragmentRunningBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRunningBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
        displayRecords()
    }

    override fun onResume() {
        super.onResume()
        displayRecords()
    }

    private fun displayRecords() {
        val runningPreferences =
            requireContext().getSharedPreferences(FILENAME, Context.MODE_PRIVATE)

        binding.textView5km.text = runningPreferences.getString(
            "5km ${EditActivityRecord.SHARED_PREFERENCE_RECORD_KEY}",
            null
        )
        binding.textView5km.text = runningPreferences.getString(
            "10km ${EditActivityRecord.SHARED_PREFERENCE_RECORD_KEY}",
            null
        )
        binding.textView5km.text = runningPreferences.getString(
            "15km ${EditActivityRecord.SHARED_PREFERENCE_RECORD_KEY}",
            null
        )
        binding.textView5km.text = runningPreferences.getString(
            "20km ${EditActivityRecord.SHARED_PREFERENCE_RECORD_KEY}",
            null
        )


    }

    private fun setupClickListeners() {
        binding.container5km.setOnClickListener { loadingRunningRecordScreen("5km", "Distance") }
        binding.container10km.setOnClickListener { loadingRunningRecordScreen("10km", "Distance") }
        binding.container15km.setOnClickListener { loadingRunningRecordScreen("15km", "Distance") }
        binding.container20km.setOnClickListener { loadingRunningRecordScreen("20km", "Distance") }

        binding.buttonClearRecords.setOnClickListener { }
    }

    private fun loadingRunningRecordScreen(distance: String, hint: String) {
        val intent = Intent(context, EditActivityRecord::class.java)
        intent.putExtra(
            "screen_data",
            EditActivityRecord.ScreenData(distance, FILENAME, hint)
        )
        startActivity(intent)
    }

    companion object {
        const val FILENAME = "running"
    }

}