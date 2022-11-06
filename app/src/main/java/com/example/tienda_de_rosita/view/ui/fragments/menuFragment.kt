package com.example.tienda_de_rosita.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.tienda_de_rosita.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class menuFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btm= view.findViewById<BottomNavigationView>(R.id.buttonNavigationMenu)
        btm.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.configuracionm -> findNavController().navigate(R.id.action_menuFragment_to_configuracionFragment)
                R.id.homem -> findNavController().navigate(R.id.action_menuFragment_self)
                R.id.carritom -> findNavController().navigate(R.id.action_menuFragment_to_carritoFragment)
            }
        }
    }

}