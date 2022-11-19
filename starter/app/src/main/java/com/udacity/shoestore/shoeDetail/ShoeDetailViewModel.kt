package com.udacity.shoestore.shoeDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeDetailViewModel : ViewModel() {
    private val _eventSaveShoe = MutableLiveData<Boolean>()
    private val _eventCancelShoeAdd = MutableLiveData<Boolean>()

    val eventSaveShoe: LiveData<Boolean>
        get() = _eventSaveShoe

    init {
        _eventSaveShoe.value = false
        _eventCancelShoeAdd.value = false
    }

    fun saveShoe() {
        _eventSaveShoe.value = true
    }

    fun onShoeSaved() {
        _eventSaveShoe.value = false
    }


    val eventCancelShoeAdd: LiveData<Boolean>
        get() = _eventCancelShoeAdd


    fun cancelShoeAdd() {
        _eventCancelShoeAdd.value = true
    }

    fun onShoeAddCancelled() {
        _eventCancelShoeAdd.value = false
    }
}