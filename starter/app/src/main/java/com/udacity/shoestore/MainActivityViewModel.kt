package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class MainActivityViewModel: ViewModel() {
    private val _shoeList = MutableLiveData<List<Shoe>>()
    private  val _shoeTobeAdded = MutableLiveData<Shoe?>()
    val  shoeList: LiveData<List<Shoe>>
        get() = _shoeList
    val shoeTobeAdded: MutableLiveData<Shoe?>
            get() = _shoeTobeAdded
    init {
        if(_shoeList.value == null || _shoeList.value!!.isEmpty()) _shoeList.value = getSampleShoeData()
    }
    fun addShoeItem(shoe:Shoe){
        _shoeList.value = _shoeList.value?.plus(shoe)?: mutableListOf(shoe)
    }
    private fun getSampleShoeData(): MutableList<Shoe>{
        return mutableListOf(
            Shoe("Air forces",11.54,"Nike","descreption_1",listOf("https://www.shutterstock.com/image-photo/zhlobin-belarus-january-10-2021-600w-1897505821.jpg"))
            , Shoe("Ballet shoe",13.75,"Adidas","descreption_2",listOf("https://images.unsplash.com/photo-1542291026-7eec264c27ff?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80"))
            , Shoe("Pointe shoe",17.34,"Kering","descreption_3",listOf("https://images.unsplash.com/photo-1549298916-b41d501d3772?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1412&q=80"))
                  )
    }
    fun setShoeToBeAdded(shoe:Shoe){
        _shoeTobeAdded.value = shoe
    }
    fun clearShoeTobeAdded(){
        _shoeTobeAdded.value = null;
    }
}