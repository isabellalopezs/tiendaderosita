package com.example.tienda_de_rosita.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.tienda_de_rosita.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase


class AgregarPFragment : Fragment() {

    lateinit var tipro:EditText
    lateinit var valpro:EditText
    lateinit var descpro:EditText
    lateinit var urlpro:EditText
    lateinit var btmagregar:Button
    val database: FirebaseFirestore = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_agregar_p, container, false)
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btm= view.findViewById<BottomNavigationView>(R.id.buttonNavigationMenu)
        btm.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.configuracionm -> findNavController().navigate(R.id.action_agregarPFragment_to_configuracionFragment)
                R.id.homem -> findNavController().navigate(R.id.action_agregarPFragment_to_menuFragment)
                R.id.carritom -> findNavController().navigate(R.id.action_agregarPFragment_to_carritoFragment)
            }
        }
        tipro=view.findViewById(R.id.nombreproduc)
        valpro=view.findViewById(R.id.valorproduc)
        descpro=view.findViewById(R.id.descproduc)
        urlpro=view.findViewById(R.id.urlproduc)
        btmagregar=view.findViewById(R.id.buttonagregarproduc)
        btmagregar.setOnClickListener{
            guardarprod()
        }
    }
    fun guardarprod(){
        val namea:String=tipro.text.toString()
        val nameb:String=valpro.text.toString()
        val namec:String=descpro.text.toString()
        val named:String=urlpro.text.toString()

        val comment= hashMapOf(
            "titulo" to namea,
            "precio" to nameb,
            "descripcion" to namec,
            "imagen" to named,
        )
        database.collection("productos")
            .document(namea)
            .set(comment)
            .addOnSuccessListener {
                Toast.makeText(context,"Producto agregado exitosamente.", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_agregarPFragment_to_menuFragment)
            }
    }
}