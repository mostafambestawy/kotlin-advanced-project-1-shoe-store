package com.udacity.shoestore.login

import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Credential
import com.udacity.shoestore.utils.Constants


class LoginViewModel : ViewModel() {
     private val _userName = MutableLiveData<String>()
    init {

    }

    val  loggedIn: LiveData<Boolean>
        get() = _loggedIn
    private val _loggedIn = MutableLiveData<Boolean>()

    val userName: LiveData<String>
        get() = _userName
    private val _password = MutableLiveData<String>()
    val password: LiveData<String>
        get() = _password

    fun login(credential: Credential): Boolean {
        return credential == Constants.APP_CREDENTIAL
    }
    fun onLogin(){
        //TODO handle navigation to welcome screen or show help info

    }
    fun onLoginFailed(){
        //Todo show help
    }

}