package com.example.tienda_de_rosita.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tienda_de_rosita.model.productos
import com.example.tienda_de_rosita.repositorio.repo

class ProductViewModel:ViewModel() {
    val repo=repo()
    fun productData():LiveData<MutableList<productos>>{
        val mutabledata=MutableLiveData<MutableList<productos>>()
        repo.getproductData().observeForever {result->
            mutabledata.value=result
        }
        return mutabledata
    }
}