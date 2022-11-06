package com.example.tienda_de_rosita.view.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.tienda_de_rosita.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class ConfiguracionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_configuracion, container, false)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btm= view.findViewById<BottomNavigationView>(R.id.buttonNavigationMenu)
        btm.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.configuracionm -> findNavController().navigate(R.id.action_configuracionFragment_self)
                R.id.homem -> findNavController().navigate(R.id.action_configuracionFragment_to_menuFragment)
                R.id.carritom -> findNavController().navigate(R.id.action_configuracionFragment_to_carritoFragment)
            }
        }

        val btmp=view.findViewById<TextView>(R.id.texp)
        btmp.setOnClickListener{
            findNavController().navigate(R.id.action_configuracionFragment_to_perfilFragment)
        }

        val btmc=view.findViewById<TextView>(R.id.texc)
        btmc.setOnClickListener{
            findNavController().navigate(R.id.action_configuracionFragment_to_comentariosFragment2)
        }

        val btmi=view.findViewById<TextView>(R.id.texi)
        btmi.setOnClickListener{
            findNavController().navigate(R.id.action_configuracionFragment_to_informacionFragment)
        }

        val btmt=view.findViewById<TextView>(R.id.textt)
        btmt.setOnClickListener{
            findNavController().navigate(R.id.action_configuracionFragment_to_terminosFragment)
        }

        val botons=view.findViewById<Button>(R.id.buttonsalirc)
        botons.setOnClickListener{
            findNavController().navigate(R.id.action_configuracionFragment_to_loginActivity)
        }

    }

}