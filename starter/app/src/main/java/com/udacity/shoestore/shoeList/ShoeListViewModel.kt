package com.udacity.shoestore.shoeList

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel: ViewModel() {
    private val _shoeList = MutableLiveData<List<Shoe>>()
    val  shoeList: LiveData<List<Shoe>>
        get() = _shoeList


    override fun onCleared() {
        super.onCleared()
        Log.i("ShoeListViewModel","cleared")
    }



    init {
        if(_shoeList.value == null || _shoeList.value!!.isEmpty()) _shoeList.value = getSampleShoeData()

    }

    private fun getSampleShoeData(): MutableList<Shoe>{
        return mutableListOf(
            Shoe("Air forces",11.54,"Nike","descreption_1",listOf("https://www.shutterstock.com/image-photo/zhlobin-belarus-january-10-2021-600w-1897505821.jpg"))
            , Shoe("Ballet shoe",13.75,"Adidas","descreption_2",listOf("https://images.unsplash.com/photo-1542291026-7eec264c27ff?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80"))
            , Shoe("Pointe shoe",17.34,"Kering","descreption_3",listOf("https://images.unsplash.com/photo-1549298916-b41d501d3772?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1412&q=80"))
            /*,Shoe("Bast shoe",17.14,"VF Corp","descreption_4",listOf("https://www.shutterstock.com/image-photo/zhlobin-belarus-january-10-2021-600w-1897505821.jpg"))
            ,Shoe("Blucher shoe",11.58,"Skechers","descreption_5",listOf("https://www.shutterstock.com/image-photo/zhlobin-belarus-january-10-2021-600w-1897505821.jpg"))
            ,Shoe("Boat shoe",18.81,"New Balance","descreption_6",listOf("https://www.shutterstock.com/image-photo/zhlobin-belarus-january-10-2021-600w-1897505821.jpg"))
            ,Shoe("Brogan (shoes)",11.69,"Burberry","descreption_7",listOf("https://www.shutterstock.com/image-photo/zhlobin-belarus-january-10-2021-600w-1897505821.jpg"))
            ,Shoe("Brogue shoe",13.93,"Asics Corp","descreption_8",listOf("https://www.shutterstock.com/image-photo/zhlobin-belarus-january-10-2021-600w-1897505821.jpg"))
            ,Shoe("Brothel creeper",17.03,"Fila","descreption_9",listOf("https://www.shutterstock.com/image-photo/zhlobin-belarus-january-10-2021-600w-1897505821.jpg"))
            ,Shoe("Bucks",15.19,"Wolverine Worldwide","descreption_10",listOf("https://www.shutterstock.com/image-photo/zhlobin-belarus-january-10-2021-600w-1897505821.jpg"))
            ,Shoe("Cantabrian albarcas",19.08,"Nike","descreption_11",listOf("https://www.shutterstock.com/image-photo/zhlobin-belarus-january-10-2021-600w-1897505821.jpg"))
            ,Shoe("Chelsea boot",15.34,"Adidas","descreption_12",listOf("https://www.shutterstock.com/image-photo/zhlobin-belarus-january-10-2021-600w-1897505821.jpg"))
            ,Shoe("Chopine",14.89,"Kering","descreption_13",listOf("https://www.shutterstock.com/image-photo/zhlobin-belarus-january-10-2021-600w-1897505821.jpg"))
            ,Shoe("Chukka boot",15.38,"VF Corp","descreption_14",listOf("https://www.shutterstock.com/image-photo/zhlobin-belarus-january-10-2021-600w-1897505821.jpg"))
            ,Shoe("Climbing shoe",17.83,"Skechers","descreption_15",listOf("https://www.shutterstock.com/image-photo/zhlobin-belarus-january-10-2021-600w-1897505821.jpg"))
            ,Shoe("Clog",17.28,"New Balance","descreption_16",listOf("https://www.shutterstock.com/image-photo/zhlobin-belarus-january-10-2021-600w-1897505821.jpg"))
            ,Shoe("Court shoe ",10.71,"Burberry","descreption_17",listOf("https://www.shutterstock.com/image-photo/zhlobin-belarus-january-10-2021-600w-1897505821.jpg"))
            ,Shoe("Cross country running shoe",15.77,"Asics Corp","descreption_18",listOf("https://www.shutterstock.com/image-photo/zhlobin-belarus-january-10-2021-600w-1897505821.jpg"))
            ,Shoe("Derby shoe",10.77,"Fila","descreption_19",listOf("https://www.shutterstock.com/image-photo/zhlobin-belarus-january-10-2021-600w-1897505821.jpg"))
            ,Shoe("Desert Boot",16.59,"Wolverine Worldwide","descreption_20",listOf("https://www.shutterstock.com/image-photo/zhlobin-belarus-january-10-2021-600w-1897505821.jpg"))
            ,Shoe("Diabetic shoe",10.4,"Nike","descreption_21",listOf("https://www.shutterstock.com/image-photo/zhlobin-belarus-january-10-2021-600w-1897505821.jpg"))
            ,Shoe("Dress shoe",18.16,"Adidas","descreption_22",listOf("https://www.shutterstock.com/image-photo/zhlobin-belarus-january-10-2021-600w-1897505821.jpg"))
            ,Shoe("Duckbill shoe",12.17,"Kering","descreption_23",listOf("https://www.shutterstock.com/image-photo/zhlobin-belarus-january-10-2021-600w-1897505821.jpg"))
            ,Shoe("Driving moccasins",10.82,"VF Corp","descreption_24",listOf("https://www.shutterstock.com/image-photo/zhlobin-belarus-january-10-2021-600w-1897505821.jpg"))
            ,Shoe("Earth shoe",19.97,"Skechers","descreption_25",listOf("https://www.shutterstock.com/image-photo/zhlobin-belarus-january-10-2021-600w-1897505821.jpg"))
            ,Shoe("Elevator shoes",16.23,"New Balance","descreption_26",listOf("https://www.shutterstock.com/image-photo/zhlobin-belarus-january-10-2021-600w-1897505821.jpg"))
            ,Shoe("Espadrille",18.96,"Burberry","descreption_27",listOf("https://www.shutterstock.com/image-photo/zhlobin-belarus-january-10-2021-600w-1897505821.jpg"))
            ,Shoe("Fashion boot",14.48,"Asics Corp","descreption_28",listOf("https://www.shutterstock.com/image-photo/zhlobin-belarus-january-10-2021-600w-1897505821.jpg"))
            ,Shoe("Galesh",12.31,"Fila","descreption_29",listOf("https://www.shutterstock.com/image-photo/zhlobin-belarus-january-10-2021-600w-1897505821.jpg"))
            ,Shoe("Geta",10.24,"Wolverine Worldwide","descreption_30",listOf("https://www.shutterstock.com/image-photo/zhlobin-belarus-january-10-2021-600w-1897505821.jpg"))
            ,Shoe("Giveh",15.98,"Nike","descreption_31",listOf("https://www.shutterstock.com/image-photo/zhlobin-belarus-january-10-2021-600w-1897505821.jpg"))
            ,Shoe("High-heeled footwear",12.57,"Adidas","descreption_32",listOf("https://www.shutterstock.com/image-photo/zhlobin-belarus-january-10-2021-600w-1897505821.jpg"))
            */
        )
    }

    fun addShoeItem(shoe:Shoe){
        _shoeList.value = _shoeList.value?.plus(shoe)?: mutableListOf(shoe)
    }


}