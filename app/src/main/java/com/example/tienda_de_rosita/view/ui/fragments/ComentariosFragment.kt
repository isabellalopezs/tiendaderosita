package com.example.tienda_de_rosita.view.ui.fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tienda_de_rosita.R
import com.example.tienda_de_rosita.view.adapter.ComentariosAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.lang.ref.PhantomReference


class ComentariosFragment : Fragment() {
    lateinit var nombre:EditText
    lateinit var correo:EditText
    lateinit var comentario:EditText
    lateinit var dbReference: DatabaseReference
    lateinit var enviarc:Button
    lateinit  var database: FirebaseDatabase
    lateinit var recyclerCom: RecyclerView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_comentarios, container, false)
        recyclerCom=view.findViewById(R.id.recyclerviewcom)
        val adapterComentarios=ComentariosAdapter()
        recyclerCom.layoutManager=LinearLayoutManager(context)
        recyclerCom.adapter=adapterComentarios
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        database=FirebaseDatabase.getInstance()
        dbReference=database.reference.child("Comentarios")
        nombre= view.findViewById(R.id.nombrec)
        correo=view.findViewById(R.id.emailc)
        comentario=view.findViewById(R.id.comentariosc)
        enviarc=view.findViewById(R.id.enviarc)
        enviarc.setOnClickListener{
            guardarcoment()
        }

        val btm = view.findViewById<BottomNavigationView>(R.id.buttonNavigationMenu)
        btm.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.configuracionm -> findNavController().navigate(R.id.action_comentariosFragment2_to_configuracionFragment)
                R.id.homem -> findNavController().navigate(R.id.action_comentariosFragment2_to_menuFragment)
                R.id.carritom -> findNavController().navigate(R.id.action_comentariosFragment2_to_carritoFragment)
            }
        }
        val botona=view.findViewById<Button>(R.id.atrasc)
        botona.setOnClickListener{
            findNavController().navigate(R.id.action_comentariosFragment2_to_configuracionFragment)
        }

    }
    fun guardarcoment(){
        val namea:String=nombre.text.toString()
        val nameb:String=correo.text.toString()
        val namec:String=comentario.text.toString()

        val userdb=dbReference.child(toString())
        userdb.child("Nombre").setValue(namea)
        userdb.child("Correo").setValue(nameb)
        userdb.child("Comentarios").setValue(namec)
        Toast.makeText(context, "Gracias por su comentario", Toast.LENGTH_SHORT).show()
    }



}
