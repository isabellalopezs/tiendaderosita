package com.example.tienda_de_rosita.view.ui.fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tienda_de_rosita.R
import com.example.tienda_de_rosita.model.compras
import com.example.tienda_de_rosita.view.adapter.ComprasAdapter
import com.example.tienda_de_rosita.view.adapter.OnCompraItemClickListener
import com.example.tienda_de_rosita.viewmodel.ComprasViwModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.firestore.FirebaseFirestore


class CarritoFragment : Fragment(), OnCompraItemClickListener {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ComprasAdapter
    lateinit var precioT: TextView
    lateinit var compraT:TextView
    lateinit var subt:TextView
    lateinit var iv:TextView
    val database: FirebaseFirestore=FirebaseFirestore.getInstance()
    private val viewModel by lazy { ViewModelProvider(this).get(ComprasViwModel::class.java) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_carrito, container, false)
        recyclerView=view.findViewById(R.id.recyclerviewcompras)
        precioT=view.findViewById(R.id.preciototal)
        compraT=view.findViewById(R.id.realizar)
        iv=view.findViewById(R.id.iva)
        subt=view.findViewById(R.id.subtotal)
        adapter= ComprasAdapter(requireContext(),this)
        recyclerView.layoutManager=LinearLayoutManager(context)
        recyclerView.adapter=adapter
        abserData()
        preciototla()
        subtotal()
        eliva()
        compraT.setOnClickListener{
            realizarcompra()
        }
        return view

    }

    private fun abserData() {
        viewModel.fetchComprasData().observe(viewLifecycleOwner, Observer {
            adapter.setListData(it)
            adapter.notifyDataSetChanged()
        })
    }

    private fun preciototla(){
        database.collection("compras")
            .get()
            .addOnSuccessListener {
                result->
                val preciounitario= mutableListOf<String>()
                for(document in result){
                    val precio=document["precio"].toString()
                    preciounitario.add(precio!!)
                }
                val preciototal = preciounitario.mapNotNull{it.toIntOrNull()}.sum()
                precioT.setText(Integer.toString(preciototal))
            }

    }

    private fun eliva(){
        database.collection("compras")
            .get()
            .addOnSuccessListener {
                    result->
                val preciounitario= mutableListOf<String>()
                for(document in result){
                    val precio=document["precio"].toString()
                    preciounitario.add(precio!!)
                }
                val preciototal = preciounitario.mapNotNull{it.toIntOrNull()}.sum()
                var sub = (preciototal*0.19).toInt()
                iv.setText(sub.toString())
            }

    }

    private fun subtotal(){
        database.collection("compras")
            .get()
            .addOnSuccessListener {
                    result->
                val preciounitario= mutableListOf<String>()
                for(document in result){
                    val precio=document["precio"].toString()
                    preciounitario.add(precio!!)
                }
                val preciototal = preciounitario.mapNotNull{it.toIntOrNull()}.sum()
                var sub = (preciototal*0.19).toInt()
                var elsub= preciototal-sub
                subt.setText(elsub.toString())
            }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btm = view.findViewById<BottomNavigationView>(R.id.buttonNavigationMenu)
        btm.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.configuracionm -> findNavController().navigate(R.id.action_carritoFragment_to_configuracionFragment)
                R.id.homem -> findNavController().navigate(R.id.action_carritoFragment_to_menuFragment)
                R.id.carritom -> findNavController().navigate(R.id.action_carritoFragment_self)
            }
        }


    }
    private fun realizarcompra(){
        val builder=AlertDialog.Builder(requireContext())
        builder.setTitle("Compra Tienda Rosita")
        builder.setMessage("¿Desea Realizar esta compra?")
        builder.setPositiveButton("Aceptar"){
            dialog,which->
            guardarfactura()
            findNavController().navigate(R.id.menuFragment)
            Toast.makeText(context, "Compra exitosa", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("Cancelar",null)
        builder.show()
    }

    override fun onItemclick(producto: compras, position: Int) {
        database.collection("compras")
            .document(producto.titulo)
            .delete()
        findNavController().navigate(R.id.carritoFragment)
    }
    fun guardarfactura(){
        val namea:String=subt.text.toString()
        val nameb:String=iv.text.toString()
        val namec:String=precioT.text.toString()

        val comment= hashMapOf(
            "Subtotal" to namea,
            "Iva 19%" to nameb,
            "Total" to namec
        )
        database.collection("Facturas")
            .document(nameb)
            .set(comment)
    }

}