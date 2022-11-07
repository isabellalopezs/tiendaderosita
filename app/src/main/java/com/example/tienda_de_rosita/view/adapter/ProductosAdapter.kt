package com.example.tienda_de_rosita.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.tienda_de_rosita.R

class ProductosAdapter: RecyclerView.Adapter<ProductosAdapter.ViewHolder>(){
    override fun onCreateViewHolder(viewGroup: ViewGroup, i:Int): ViewHolder {
        val v= LayoutInflater.from(viewGroup.context).inflate(R.layout.card_view_productos, viewGroup, false)
        return ViewHolder(v)
    }

    inner class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemPrecio: TextView

        init{
            itemImage=ItemView.findViewById(R.id.image)
            itemTitle=ItemView.findViewById(R.id.titulo)
            itemPrecio=ItemView.findViewById(R.id.precio)
        }
    }

    val titles= arrayOf("Parfait", "Fresas", "Galletas", "Gelatina", "Muffin")
    val precio= arrayOf("$10.000", "$2.000", "$2.500", "$5.000", "$4.000")
    val image= arrayOf(R.drawable.postreuno, R.drawable.fresas, R.drawable.galletas, R.drawable.gelatina, R.drawable.muffin)

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text=titles[i]
        viewHolder.itemPrecio.text=precio[i]
        viewHolder.itemImage.setImageResource(image[i])
    }

    override fun getItemCount(): Int {
        return titles.size
    }
}