package com.yarin.recordkeeper

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yarin.recordkeeper.databinding.ActivityMainBinding
import com.yarin.recordkeeper.fragment.BikingFragment
import com.yarin.recordkeeper.fragment.RunningFragment



class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.bottomNav.setOnNavigationItemSelectedListener(this)

    }

    private fun onBikingClicked() {
        supportFragmentManager.commit { replace(R.id.frame, BikingFragment()) }
    }

    private fun onRunningClicked() {
        supportFragmentManager.commit { replace(R.id.frame, RunningFragment()) }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.nav_bike -> {
                onBikingClicked()
                return true
            }
            R.id.nav_running -> {
                onRunningClicked()
                return true
            }
            else -> return false
        }
    }

}