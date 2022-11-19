package com.example.tienda_de_rosita.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.tienda_de_rosita.R
import com.example.tienda_de_rosita.model.comentarios

class ComentariosAdapter(private val context: Context): RecyclerView.Adapter<ComentariosAdapter.ViewHolder>() {
    private var comentarioslista= mutableListOf<comentarios>()

    fun setListDataCom(data:MutableList<comentarios>){
        comentarioslista=data
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i:Int): ViewHolder{
        val v= LayoutInflater.from(viewGroup.context).inflate(R.layout.card_view_comentarios, viewGroup, false)
        return ViewHolder(v)
    }

    inner class ViewHolder(ItemView:View): RecyclerView.ViewHolder(ItemView){
        fun binWewC(comentario:comentarios){
            itemView.findViewById<TextView>(R.id.correo).text=comentario.Correo
            itemView.findViewById<TextView>(R.id.nombre).text=comentario.Nombre
            itemView.findViewById<TextView>(R.id.comentario).text=comentario.Comentarios
        }
    }



    override fun onBindViewHolder(vieHolder: ViewHolder, i: Int) {
        val comentario=comentarioslista[i]
        vieHolder.binWewC(comentario)
    }

    override fun getItemCount(): Int {
        return if(comentarioslista.size>0){
            comentarioslista.size
        }else{
            0
        }
    }
}