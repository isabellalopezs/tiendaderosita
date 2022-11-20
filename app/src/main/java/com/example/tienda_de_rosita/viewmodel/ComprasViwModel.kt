package com.example.tienda_de_rosita.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tienda_de_rosita.model.compras
import com.example.tienda_de_rosita.repositorio.repo

class ComprasViwModel:ViewModel() {
    val repo=repo()
    fun fetchComprasData():LiveData<MutableList<compras>>{
        val mutableData=MutableLiveData<MutableList<compras>>()
        repo.getCompraData().observeForever {
            mutableData.value=it
        }
        return mutableData
    }
}