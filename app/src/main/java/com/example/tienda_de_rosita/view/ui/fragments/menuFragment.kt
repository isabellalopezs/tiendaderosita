package com.example.tienda_de_rosita.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tienda_de_rosita.R
import com.example.tienda_de_rosita.view.adapter.ProductosAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView


class menuFragment : Fragment() {

    lateinit var recyclerProduc: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.fragment_menu, container, false)
        recyclerProduc= view.findViewById(R.id.recyclerview)
        val adapter=ProductosAdapter()
        recyclerProduc.layoutManager= LinearLayoutManager(context)
        recyclerProduc.adapter=adapter
        return view
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