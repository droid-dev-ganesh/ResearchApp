package com.ganesh.researchapp.mvvmexample.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.ganesh.researchapp.mvvmexample.repository.localdatasource.models.User

class UserProfileViewModel constructor(handle: SavedStateHandle): ViewModel() {

    var userId : String = ""
    private var user : MutableLiveData<User> = MutableLiveData()


    fun setUserID(userId:String){
        this.userId = userId
    }

    fun getUserID():String{
        return userId
    }

    fun setUser(name:String,mobile:String){
        val userObject = User(name,mobile)
        user.value = userObject
    }

    fun getUser():MutableLiveData<User>{
        return user
    }
}