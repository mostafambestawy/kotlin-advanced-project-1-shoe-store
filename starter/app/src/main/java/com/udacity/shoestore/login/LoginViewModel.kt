package com.udacity.shoestore.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.utils.Constants


class LoginViewModel : ViewModel() {
    private val _userName = MutableLiveData<String>()

    private val _loggedIn = MutableLiveData<Boolean>()
    val loggedIn: LiveData<Boolean>
        get() = _loggedIn
    init {
        _loggedIn.value = false
    }

    val userName: LiveData<String>
        get() = _userName
    private val _password = MutableLiveData<String>()
    val password: LiveData<String>
        get() = _password


    fun checkCredential() {
        //TODO delete after debug
        _loggedIn.value = true
        /*if (_userName.value.toString().trim() == Constants.APP_CREDENTIAL.userName
            && _password.value.toString().trim() == Constants.APP_CREDENTIAL.password
        )
            _loggedIn.value = true
        else {
            _loggedIn.value = false
            resetCredential()
        }*/

    }

    fun updateUserName(userName: String) {
        _userName.value = userName
    }

    fun updatePassword(password: String) {
        _password.value = password
    }

    private fun resetCredential() {
        _userName.value = ""
        _password.value = ""
    }

}