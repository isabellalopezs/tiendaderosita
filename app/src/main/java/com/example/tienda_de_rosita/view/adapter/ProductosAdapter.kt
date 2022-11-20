package com.example.tienda_de_rosita.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.tienda_de_rosita.R
import com.example.tienda_de_rosita.model.productos
import android.content.Context
import android.widget.ImageButton
import com.squareup.picasso.Picasso


class ProductosAdapter(private val context: Context,var clickListener: OnBookItemClickListener): RecyclerView.Adapter<ProductosAdapter.ViewHolder>(){

    private var productosLista=mutableListOf<productos>()

    fun setListData(data:MutableList<productos>){
        productosLista=data
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i:Int): ViewHolder {
        val v= LayoutInflater.from(viewGroup.context).inflate(R.layout.card_view_productos, viewGroup, false)
        return ViewHolder(v)
    }

    inner class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
        fun binWew(producto:productos, action: OnBookItemClickListener){
            itemView.findViewById<TextView>(R.id.titulo).text=producto.titulo
            itemView.findViewById<TextView>(R.id.precio).text=producto.precio
            itemView.findViewById<TextView>(R.id.descripcion).text=producto.descripcion
            Picasso.with(context).load(producto.imagen).into(itemView.findViewById<ImageView>(R.id.image))
            val btncarrito=itemView.findViewById<ImageButton>(R.id.carrito)
            btncarrito.setOnClickListener{
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
interface OnBookItemClickListener{
    fun onItemclick(producto: productos, position:Int)
}