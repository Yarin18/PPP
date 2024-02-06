package com.yarin.marketingapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.yarin.marketingapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonPreview.setOnClickListener {
            onPreviewClicked()
        }

        val spinnerValues: Array<String> = arrayOf("Android Developer", "Android Engineer")
        val spinnerAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerValues)
        binding.spinner.adapter = spinnerAdapter
    }

    private fun onPreviewClicked() {

        val message = Message(
            binding.editTextContactName.text.toString(),
            binding.editTextContactNumber.text.toString(),
            binding.editTextContactDisplayname.text.toString(),
            binding.checkBoxJunior.isChecked,
            binding.spinner.selectedItem?.toString(),
            binding.checkBoxImmediateStart.isChecked,
            binding.editTextStartDate.text.toString()
        )

        val previewActivityIntent = Intent(this, PreviewActivity::class.java)
        previewActivityIntent.putExtra("message", message)
        startActivity(previewActivityIntent)
    }


}