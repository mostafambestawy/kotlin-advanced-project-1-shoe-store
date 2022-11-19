package com.udacity.shoestore.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel: ViewModel() {
    private val _eventOpenInstructionsScreen = MutableLiveData<Boolean>()
    val eventOpenInstructionsScreen: LiveData<Boolean>
        get() = _eventOpenInstructionsScreen

    init {
        _eventOpenInstructionsScreen.value = false
    }

    fun openInstructionsScreen() {
        _eventOpenInstructionsScreen.value = true
    }

    fun onInstructionsScreenOpened() {
        _eventOpenInstructionsScreen.value = false
    }

}