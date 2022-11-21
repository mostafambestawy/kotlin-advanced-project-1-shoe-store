package com.udacity.shoestore.shoeDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeDetailViewModel : ViewModel() {
    private val _eventSaveShoe = MutableLiveData<Boolean>()
    private val _eventCancelShoeAdd = MutableLiveData<Boolean>()
    var shoeName = MutableLiveData<String>()
    var shoeCompany = MutableLiveData<String>()
    var shoeSize = MutableLiveData<Double?>()
    var shoeDescription = MutableLiveData<String>()

    /*fun setShoeName(name: String) {
        shoeName.value = name
    }

    fun setShoeCompany(company: String) {
        shoeCompany.value = company
    }

    fun setShoeSize(size: String) {
        val sizeDouble = size.toDoubleOrNull()
        if (sizeDouble != null)
            shoeSize.value = sizeDouble
        else shoeSize.value = 0.0
    }

    fun setShoeDescription(description: String) {
        shoeDescription.value = description
    }*/

    init {
        shoeName.value = ""
        shoeCompany.value = ""
        shoeSize.value = 0.0
        shoeDescription.value = ""

    }

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