package com.ganesh.researchapp.mvpexample.presenters

import com.ganesh.researchapp.mvpexample.model.ReminderModel
import java.lang.Exception

class MainPresenter(
    mainViewInterface: MainViewInterface,
    getReminderInteractor: GetReminderInteractor
) : MainPresenterInterface,GetReminderInteractor.OnFinishedListener {

    private var mainView: MainViewInterface? = mainViewInterface
    private var getReminder: GetReminderInteractor = getReminderInteractor



    override fun onFinished(reminder: ReminderModel) {
        mainView!!.setReminder(reminder)
        mainView!!.hideProgress()
    }

    override fun onButtonPressed() {
        try {
            mainView!!.showProgress()
        }catch (e:Exception){

        }

        getReminder.getNextReminder(this)
    }

    override fun onDestroy() {
        mainView =  null
    }
}