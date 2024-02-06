package com.yarin.getitdone

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.tabs.TabLayoutMediator
import com.yarin.getitdone.data.Task
import com.yarin.getitdone.data.TaskDao
import com.yarin.getitdone.databinding.ActivityMainBinding
import com.yarin.getitdone.databinding.DialogAddTaskBinding
import com.yarin.getitdone.db.GetItDoneDatabase
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var database: GetItDoneDatabase
    private val taskFragment: TasksFragment = TasksFragment()

    private val taskDao: TaskDao by lazy { database.getTaskDao() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pager.adapter = PagerAdapter(this)
        TabLayoutMediator(binding.tabs, binding.pager) { tab, position ->
            tab.text = "Tasks"
        }.attach()

        binding.fab.setOnClickListener { showAddTaskDialog() }

        database = GetItDoneDatabase.getDatabase(this)


    }

    private fun showAddTaskDialog() {
        val dialogBinding = DialogAddTaskBinding.inflate(layoutInflater)

        val dialog = BottomSheetDialog(this)
        dialog.setContentView(dialogBinding.root)

        dialogBinding.buttonShowDetails.setOnClickListener {
            if (dialogBinding.editTextTaskDetails.visibility == View.VISIBLE) {
                dialogBinding.editTextTaskDetails.visibility = View.GONE
            } else dialogBinding.editTextTaskDetails.visibility = View.VISIBLE
        }

        dialogBinding.buttonSave.setOnClickListener {
            val task = Task(
                title = dialogBinding.editTextTaskTitle.text.toString(),
                description = dialogBinding.editTextTaskDetails.text.toString()
            )

            thread {
                taskDao.createTask(task)
            }
            dialog.dismiss()
            taskFragment.fetchAllTasks()
        }

        dialog.show()
    }

    inner class PagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int {
            return 1
        }

        override fun createFragment(position: Int): Fragment {
            return taskFragment
        }
    }
}