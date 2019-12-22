package com.ganesh.researchapp.mvpexample.presenters

import com.ganesh.researchapp.mvpexample.model.ReminderModel

interface MainViewInterface {
    fun showProgress()

    fun hideProgress()

    fun setReminder(reminder:ReminderModel)
}