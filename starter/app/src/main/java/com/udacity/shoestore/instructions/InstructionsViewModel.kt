package com.udacity.shoestore.instructions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InstructionsViewModel : ViewModel() {
    private val _acceptInstructions = MutableLiveData<Boolean>()
    val  acceptInstructions: LiveData<Boolean>
        get() = _acceptInstructions

    fun acceptInstructions(){
        _acceptInstructions.value = true
    }
}