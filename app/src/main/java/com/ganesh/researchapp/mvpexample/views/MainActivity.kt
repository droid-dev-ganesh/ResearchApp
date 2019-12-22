package com.ganesh.researchapp.mvpexample.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.ganesh.researchapp.R
import com.ganesh.researchapp.mvpexample.model.ReminderModel
import com.ganesh.researchapp.mvpexample.presenters.*

class MainActivity : AppCompatActivity(), MainViewInterface {
    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
        textView.visibility = View.INVISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.INVISIBLE
    }

    override fun setReminder(reminder: ReminderModel) {
        textView.text = reminder.reminderValue
    }

    private lateinit var button:Button
    private lateinit var progressBar:ProgressBar
    private lateinit var textView:TextView
    private lateinit var mainPresenterInterface: MainPresenterInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button =findViewById(R.id.button)
        progressBar =findViewById(R.id.progressBar)
        textView =findViewById(R.id.textView)


        mainPresenterInterface = MainPresenter(this,GetReminderInteractorImpl())

        button.setOnClickListener {

            mainPresenterInterface.onButtonPressed()

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mainPresenterInterface.onDestroy()
    }
}
