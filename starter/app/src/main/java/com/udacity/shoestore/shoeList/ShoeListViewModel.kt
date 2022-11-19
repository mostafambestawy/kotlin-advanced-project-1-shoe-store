package com.udacity.shoestore.shoeList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeListViewModel: ViewModel() {
    private val _eventOpenAddShoeScreen = MutableLiveData<Boolean>()
    val  eventOpenAddShoeScreen: LiveData<Boolean>
        get() = _eventOpenAddShoeScreen
    init {
        _eventOpenAddShoeScreen.value = false
    }
    fun  openAddShoeScreen(){
        _eventOpenAddShoeScreen.value = true
    }
    fun onAddShoeScreenOpened(){
        _eventOpenAddShoeScreen.value = false
    }
}