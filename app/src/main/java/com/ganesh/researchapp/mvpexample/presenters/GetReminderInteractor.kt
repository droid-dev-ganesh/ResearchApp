package com.ganesh.researchapp.mvpexample.presenters

import com.ganesh.researchapp.mvpexample.model.ReminderModel

public interface GetReminderInteractor {

    interface OnFinishedListener{
        fun onFinished(reminder:ReminderModel)
    }

    fun getNextReminder(onFinishedListener: OnFinishedListener)
}