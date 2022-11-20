package com.example.tienda_de_rosita.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tienda_de_rosita.model.comentarios
import com.example.tienda_de_rosita.repositorio.repo

class CommentViewModel: ViewModel() {
    val repo=repo()
    fun commentData():LiveData<MutableList<comentarios>>{
        val mutabledata= MutableLiveData<MutableList<comentarios>>()
        repo.getcomentData().observeForever {result->
            mutabledata.value=result
        }
        return mutabledata
    }
}