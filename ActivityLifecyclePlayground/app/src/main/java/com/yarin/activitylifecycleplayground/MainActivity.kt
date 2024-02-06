package com.yarin.activitylifecycleplayground

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.addCallback
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.yarin.activitylifecycleplayground.databinding.ActivityMainBinding
import java.io.File
import java.util.Timer

class MainActivity : AppCompatActivity(), FragmentListener {

    private lateinit var binding: ActivityMainBinding
    private val tag: String = "Yarin"

    private var isFirstLoad: Boolean = true
    private var loadCount = 0

    private lateinit var frag: TestFragment

    var seconds = 0
    private lateinit var timer: Timer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.frag = TestFragment()
        binding.button.setOnClickListener {
            finish()
        }

        // load from phone rotate
        binding.textViewMsg.text = savedInstanceState?.getString("savedMessage")

//        Log.d(tag, "Im in OnCreate")
//        binding.textViewRefreshStatus.text = "Welcome to the app! Here is your feed..."
        findViewById<Button>(R.id.button).setOnClickListener {
//            showDialog()
            saveMessage()
        }

        onBackPressedDispatcher.addCallback(this) {
            Toast.makeText(this@MainActivity, "Back button callback", Toast.LENGTH_LONG).show()
            showDialog()
            showFrag()
        }


    }

    fun showFrag() {
        supportFragmentManager.commit {
            add(R.id.fragment, frag)
        }
    }

    fun removeFrag() {
        supportFragmentManager.commit { remove(frag) }
    }


    // save to phone rotate
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val saved = binding.textViewMsg.text.toString()
        outState.putString("savedMessage", saved)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }



    private fun saveMessage() {
        val msg = binding.textViewMsg.text
        File(filesDir, "usermsg.txt").writeText(msg.toString())
        binding.textViewMsg.text = "Saved msg \n\nMessage Preview\n\n$msg"
        binding.textViewMsg.setText("")
    }

    private fun showDialog() {
        AlertDialog.Builder(this)
            .setTitle("Warning!")
            .setView(R.layout.dialog_warning)
            .setMessage("Are u sure u want to exit?")
            .setPositiveButton("Yes") { _, _ -> finish() }
            .setNegativeButton("No") { dialog, _ -> dialog.dismiss() }
            .setNeutralButton("More info") { _, _ ->
                Toast.makeText(
                    this,
                    "More Info :)",
                    Toast.LENGTH_LONG
                ).show()
            }
            .show()
    }

//    override fun onDestroy() {
//        super.onDestroy()
//        val userMessage = binding.textViewTimer.text
//        File(filesDir, "user_msg.txt").writeText(userMessage.toString())
//    }


//    override fun onPause() {
//        super.onPause()
//        timer.cancel()
//    }
//
//    override fun onResume() {
//        super.onResume()
//        loadCount++
//
//        timer = fixedRateTimer(period = 1000L) {
//            runOnUiThread {
//                seconds++
//                binding.textViewTimer.text = "You have been staring  at this screen for $seconds"
//            }
//        }
//
//    }

    override fun onRestart() {
        super.onRestart()
//        binding.textViewRefreshStatus.text = "Your feed has been updated..."

    }

    override fun clearActivityScreen() {
        binding.textViewMsg.setText("")
        removeFrag()
    }

//    override fun onResume() {
//        super.onResume()
//        if (isFirstLoad) {
//            binding.textViewRefreshStatus.text = "Welcome to the app! Here is your feed..."
//            this.isFirstLoad = false
//        } else {
//            binding.textViewRefreshStatus.text = "Your feed has been updated..."
//
//        }
//    }


    /*  // Activity becomes visible
      override fun onStart() {
          super.onStart()
          Log.d(tag, "Im in OnStart")
      }

      // Activity is in the FOREGROUND
      override fun onResume() {
          super.onResume()
          Log.d(tag, "Im in OnResume")
      }

      // When our activity is STILL VISIBLE, but is in the BACKGROUND
      // (e.g An Activity "Dialog" is on top, but we can still see our Activity)
      override fun onPause() {
          super.onPause()
          Log.d(tag, "Im in OnPause")
      }


      // When our Activity is no longer VISIBLE (but still running)
      override fun onStop() {
          super.onStop()
          Log.d(tag, "Im in OnStop")
      }

      override fun onDestroy() {
          super.onDestroy()
          Log.d(tag, "Im in OnDestroy")
      }*/
}
interface FragmentListener
{
    fun clearActivityScreen()
}