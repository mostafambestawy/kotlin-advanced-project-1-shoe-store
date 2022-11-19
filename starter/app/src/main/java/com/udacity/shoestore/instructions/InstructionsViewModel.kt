package com.udacity.shoestore.instructions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InstructionsViewModel : ViewModel() {
    private val _eventOpenShoeListScreen = MutableLiveData<Boolean>()
    val eventOpenShoeListScreen: LiveData<Boolean>
        get() = _eventOpenShoeListScreen

    init {
        _eventOpenShoeListScreen.value = false
    }

    fun openShoeListScreen() {
        _eventOpenShoeListScreen.value = true
    }

    fun onShoeListScreenOpened() {
        _eventOpenShoeListScreen.value = false
    }
}