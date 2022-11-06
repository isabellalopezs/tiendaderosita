package com.example.tienda_de_rosita.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.tienda_de_rosita.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class TerminosFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_terminos, container, false)
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btm = view.findViewById<BottomNavigationView>(R.id.buttonNavigationMenu)
        btm.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.configuracionm -> findNavController().navigate(R.id.action_terminosFragment_to_configuracionFragment)
                R.id.homem -> findNavController().navigate(R.id.action_terminosFragment_to_menuFragment)
                R.id.carritom -> findNavController().navigate(R.id.action_terminosFragment_to_carritoFragment)
            }
        }
        val botona=view.findViewById<Button>(R.id.atrast)
        botona.setOnClickListener{
            findNavController().navigate(R.id.action_terminosFragment_to_configuracionFragment)
        }

    }
}