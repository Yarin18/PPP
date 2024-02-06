package com.yarin.recordkeeper

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.yarin.recordkeeper.databinding.ActivityEditRecordBinding
import java.io.Serializable

class EditActivityRecord : AppCompatActivity() {

    private lateinit var binding: ActivityEditRecordBinding

    private val screenData: ScreenData by lazy {
        intent.getSerializableExtra("screen_data") as ScreenData
    }

    private val recordPreferences: SharedPreferences by lazy {
        getSharedPreferences(
            screenData.sharedPreferenceName,
            Context.MODE_PRIVATE
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUi()

        /*  val appPreferences = PreferenceManager.getDefaultSharedPreferences(this)
          appPreferences.edit {
              putString("k", "v")
          }

          val activityPreferences = getPreferences(Context.MODE_PRIVATE)
          activityPreferences.edit {
              putInt("one", 1)
          }

          val fileNamePreferences = getSharedPreferences("idksomefile", Context.MODE_PRIVATE)
          fileNamePreferences.edit {
              putBoolean("idk", true)
          }*/

    }

    private fun setupUi() {
        title = "${screenData.record} Record"
        binding.textInputRecord.hint = screenData.recordFieldHint
        binding.buttonSave.setOnClickListener {
            saveRecord()
            finish()
        }
        binding.buttonDelete.setOnClickListener {
            deleteRecord()
            finish()
        }

    }

    private fun saveRecord() {
        val rec = binding.textEditRecord.text.toString()
        val date = binding.textEditDate.text.toString()

        recordPreferences.edit {
            putString("${screenData.record} record", rec)
            putString("${screenData.record} date", date)
        }
    }

    private fun deleteRecord() {
        recordPreferences.edit {
            remove("${screenData.record} record")
            remove("${screenData.record} date")
        }
    }

    private fun clearAll() {
        recordPreferences.edit { clear() }
    }

    data class ScreenData(
        val record: String,
        val sharedPreferenceName: String,
        val recordFieldHint: String
    ) : Serializable

    companion object {
        const val SHARED_PREFERENCE_RECORD_KEY = "record"
        const val SHARED_PREFERENCE_DATE_KEY = "date"
    }
}