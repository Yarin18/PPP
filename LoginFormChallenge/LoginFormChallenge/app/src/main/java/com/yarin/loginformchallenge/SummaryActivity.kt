package com.yarin.loginformchallenge

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yarin.loginformchallenge.databinding.ActivitySummaryBinding

class SummaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySummaryBinding
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        retrieveUser()
        displayUser()
        setupClickListeners()
    }

    private fun retrieveUser() {
        this.user = intent.getSerializableExtra("User") as User
    }

    private fun displayUser() {
        binding.textViewEmail.text = user.email
        binding.textViewFullname.text = user.getFullName()
        binding.textViewPhone.text = user.phone
    }


    private fun setupClickListeners() {
        binding.textViewEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:${user.email}")
        }
        binding.textViewPhone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${user.phone}")
        }
    }


}