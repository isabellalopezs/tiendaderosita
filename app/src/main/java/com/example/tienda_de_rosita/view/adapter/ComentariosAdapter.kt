package com.example.tienda_de_rosita.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.tienda_de_rosita.R

class ComentariosAdapter: RecyclerView.Adapter<ComentariosAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i:Int): ViewHolder{
        val v= LayoutInflater.from(viewGroup.context).inflate(R.layout.card_view_comentarios, viewGroup, false)
        return ViewHolder(v)
    }
    inner class ViewHolder(ItemView:View): RecyclerView.ViewHolder(ItemView){
        var itemNombre: TextView
        var itemComentario: TextView

        init{
            itemNombre=ItemView.findViewById(R.id.nombre)
            itemComentario=ItemView.findViewById(R.id.comentario)
        }
    }

    var nombres= arrayOf("Juan Sebastian","Julio Padilla","Jhonatan Lopez","Felipe Suarez","Andres Jimenez")
    var comentario = arrayOf("Que buena aplicacion :p", "muy buena la atencion", "excelentes productos","Me gusto la gelatina","Muy buena la atencion")

    override fun onBindViewHolder(vieHolder: ViewHolder, i: Int) {
        vieHolder.itemNombre.text = nombres[i]
        vieHolder.itemComentario.text = comentario[i]
    }

    override fun getItemCount(): Int {
        return nombres.size
    }
}