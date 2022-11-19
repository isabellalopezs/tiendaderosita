package com.example.tienda_de_rosita.repositorio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tienda_de_rosita.model.comentarios
import com.example.tienda_de_rosita.model.productos
import com.google.firebase.database.FirebaseDatabase
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

    fun getcomentData():LiveData<MutableList<comentarios>>{
        val mutabledatac=MutableLiveData<MutableList<comentarios>>()

        FirebaseFirestore.getInstance().collection("comentarios").get().addOnSuccessListener {result->
            val listDatac= mutableListOf<comentarios>()
            for (document in result){
                val name = document.getString("Nombre")
                val coment = document.getString("Comentario")
                val correo = document.getString("Correo")
                val comentario= comentarios(name!!,coment!!,correo!!)
                listDatac.add(comentario)
            }
            mutabledatac.value= listDatac
        }
        return mutabledatac
    }
}