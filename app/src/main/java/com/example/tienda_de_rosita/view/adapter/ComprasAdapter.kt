package com.example.tienda_de_rosita.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tienda_de_rosita.R
import com.example.tienda_de_rosita.model.compras
import com.squareup.picasso.Picasso

class ComprasAdapter(private val context: Context, var clickListener: OnCompraItemClickListener): RecyclerView.Adapter<ComprasAdapter.ViewHolder>(){

    private var productosLista=mutableListOf<compras>()

    fun setListData(data:MutableList<compras>){
        productosLista=data
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i:Int): ViewHolder {
        val v= LayoutInflater.from(viewGroup.context).inflate(R.layout.card_view_compras    , viewGroup, false)
        return ViewHolder(v)
    }

    inner class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
        fun binWew(producto: compras, action: OnCompraItemClickListener){
            itemView.findViewById<TextView>(R.id.titulo).text=producto.titulo
            itemView.findViewById<TextView>(R.id.precio).text=producto.precio
            Picasso.with(context).load(producto.imagen).into(itemView.findViewById<ImageView>(R.id.image))
            val btneliminar=itemView.findViewById<ImageButton>(R.id.eliminar)
            btneliminar.setOnClickListener{
                action.onItemclick(producto, adapterPosition)
            }
        }
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val producto = productosLista[i]
        viewHolder.binWew(producto,clickListener)
    }

    override fun getItemCount(): Int {
        return if(productosLista.size>0){
            productosLista.size
        }else{
            0
        }
    }
}
interface OnCompraItemClickListener{
    fun onItemclick(producto: compras, position:Int)
}