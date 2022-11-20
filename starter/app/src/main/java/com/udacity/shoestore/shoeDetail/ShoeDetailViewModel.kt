package com.udacity.shoestore.shoeDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeDetailViewModel : ViewModel() {
    private val _eventSaveShoe = MutableLiveData<Boolean>()
    private val _eventCancelShoeAdd = MutableLiveData<Boolean>()
    val shoeName: LiveData<String>
        get() = _shoeName
    private val _shoeName = MutableLiveData<String>()

    val shoeCompany: LiveData<String>
        get() = _shoeCompany
    private val _shoeCompany = MutableLiveData<String>()
    val shoeSize: LiveData<Double?>
        get() = _shoeSize
    private val _shoeSize = MutableLiveData<Double?>()

    val shoeDescription: LiveData<String>
        get() = _shoeDescription
    private val _shoeDescription = MutableLiveData<String>()

    fun setShoeName(name: String) {
        _shoeName.value = name
    }

    fun setShoeCompany(company: String) {
        _shoeCompany.value = company
    }

    fun setShoeSize(size: String) {
        val sizeDouble = size.toDoubleOrNull()
        if (sizeDouble != null)
            _shoeSize.value = sizeDouble
        else _shoeSize.value = 0.0
    }

    fun setShoeDescription(description: String) {
        _shoeDescription.value = description
    }

    init {
        _shoeName.value = ""
        _shoeCompany.value = ""
        _shoeSize.value = 0.0
        _shoeDescription.value = ""

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