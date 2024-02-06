package com.yarin.reminders

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.yarin.reminders.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.pager.adapter = ScreenSliderPagerAdapter(this)

        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, pos ->
            when (pos) {
                0 -> {
                    tab.text = "Passwords"
                    tab.icon = AppCompatResources.getDrawable(this, R.drawable.baseline_lock_24)
                }
                1 -> {
                    tab.text = "General Info"
                    tab.icon = AppCompatResources.getDrawable(this, R.drawable.baseline_info_24)
                }
            }
        }.attach()

    }


    private inner class ScreenSliderPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int {
            return 2
        }

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> PasswordFragment()
                else -> GeneralInfoFragment()
            }
        }
    }

}