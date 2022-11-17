package com.example.tienda_de_rosita.repositorio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tienda_de_rosita.model.productos
import com.google.firebase.firestore.FirebaseFirestore

class repo {
    fun getproductData():LiveData<MutableList<productos>>{
        val mutabledata=MutableLiveData<MutableList<productos>>()

        FirebaseFirestore.getInstance().collection("productos").get().addOnSuccessListener {result->
            val listData= mutableListOf<productos>()
            for (document in result){
                val titulo = document.getString("titulo")
                val precio = document.getString("precio")
                val image = document.getString("imagen")
                val descripcion = document.getString("descripcion")
                val producto = productos(titulo!!, precio!!, image!!, descripcion!!)
                listData.add(producto)
            }
            mutabledata.value= listData
        }
        return mutabledata
    }
}