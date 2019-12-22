package com.ganesh.researchapp.mvpexample.presenters

import android.content.Context
import android.os.Handler
import com.ganesh.researchapp.mvpexample.model.ReminderModel
import java.util.*


class GetReminderInteractorImpl: GetReminderInteractor {

    private var reminderArrayList :ArrayList<ReminderModel> = arrayListOf()

    init {

        val reminderStringArray = arrayOf("7 AM - Read News TOI",
            "9 AM - Internal Meeting on New Project Architecture",
            "12 PM - Principal Component Analysis Deadline",
            "3 PM - Client Meeting",
            "6 PM - Code Review",
            "7 PM - Update RedMine"
        )

        for (i in reminderStringArray.indices){
            reminderArrayList.add(ReminderModel(i+1,reminderStringArray[i]))
        }
    }

    override fun getNextReminder(onFinishedListener: GetReminderInteractor.OnFinishedListener) {
        Handler().postDelayed({ onFinishedListener.onFinished(getRandomString()) }, 1200)
    }

    private fun getRandomString(): ReminderModel {

        val random = Random()
        val index = random.nextInt(reminderArrayList.size)

        return reminderArrayList[index]
    }

}