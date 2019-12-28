package com.ganesh.researchapp.mvvmexample.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.SavedStateViewModelFactory
import com.ganesh.researchapp.R
import com.ganesh.researchapp.mvvmexample.viewmodels.UserProfileViewModel
import com.ganesh.researchapp.mvvmexample.views.userprofile.UserProfileFragment

class HomePageActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        if (savedInstanceState == null){
            //create an object of UserProfileFragment & pass to addFirstFragment method
            val userProfileFragment = UserProfileFragment()
            addFirstFragment(userProfileFragment)
        }

    }

    //add first fragment
    private fun addFirstFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frame_container, fragment)
        transaction.commit()
    }
}
