package com.ganesh.researchapp.mvvmexample.views.userprofile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateViewModelFactory
import com.ganesh.researchapp.R
import com.ganesh.researchapp.mvvmexample.viewmodels.UserProfileViewModel
import androidx.lifecycle.ViewModelProvider





 class UserProfileFragment: Fragment() {

    private val TAG = "UserFragment"
    private lateinit var edtUserName:EditText
    private lateinit var edtUserMobile:EditText
    private lateinit var submitButton:Button
    private var mainViewModel: UserProfileViewModel? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG,"onCreateView")
        return inflater.inflate(R.layout.frag_user_profile,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews(view)
        setListener()
    }

    private fun bindViews(view:View){
        edtUserName = view.findViewById(R.id.edt_user_name)
        edtUserMobile = view.findViewById(R.id.edt_user_mobile)
        submitButton = view.findViewById(R.id.button3)

    }

    private fun setListener(){
        submitButton.setOnClickListener {
            val name = edtUserName.text.toString()
            val mobile = edtUserMobile.text.toString()

            if (name.isNotEmpty() && mobile.length == 10){
                mainViewModel!!.setUser(name = name,mobile = mobile)
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (mainViewModel == null){
            val savedStateViewModelFactory = SavedStateViewModelFactory(activity!!.application,this)
            mainViewModel = ViewModelProvider(
                this,
                savedStateViewModelFactory
            ).get(UserProfileViewModel::class.java)

            mainViewModel!!.getUser().observe(this, Observer {
                Toast.makeText(activity,"Name: ${it.userName} | Mobile: ${it.userContact}",Toast.LENGTH_LONG).show()
            })
        }

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState: ")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d(TAG, "onViewStateRestored: ")
    }


}