package com.yarin.loginformchallenge

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.yarin.loginformchallenge.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupSpinner()
        setupButton()

    }

    private fun setupButton() {
        binding.button.setOnClickListener {
            createAccount()
        }
    }

    private fun setupSpinner() {
        val titles = arrayOf("Miss", "Mrs", "Ms", "Mr", "Mx", "Dr", "Prof")
        val titleAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, titles)
        binding.spinner.adapter = titleAdapter
    }

    private fun createAccount() {
        val user = User(
            binding.spinner.selectedItem.toString(),
            binding.editTextFirstname.text.toString(),
            binding.editTextLastname.text.toString(),
            binding.editTextEmail.text.toString(),
            binding.editTextPhone.text.toString(),
            binding.editTextPassword.text.toString(),
        )

        val intent = Intent(this, SummaryActivity::class.java)
        intent.putExtra("User", user)
        startActivity(intent)
    }

}