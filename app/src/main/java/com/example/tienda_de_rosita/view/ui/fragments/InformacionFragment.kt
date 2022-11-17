package com.example.tienda_de_rosita.view.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tienda_de_rosita.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.bottomnavigation.BottomNavigationView


class InformacionFragment : Fragment(), OnMapReadyCallback {
    lateinit var map:GoogleMap



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_informacion, container, false)
        return view
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)




        val btm = view.findViewById<BottomNavigationView>(R.id.buttonNavigationMenu)
        btm.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.configuracionm -> findNavController().navigate(R.id.action_informacionFragment_to_configuracionFragment)
                R.id.homem -> findNavController().navigate(R.id.action_informacionFragment_to_menuFragment)
                R.id.carritom -> findNavController().navigate(R.id.action_informacionFragment_to_carritoFragment)
            }
        }
        val botona = view.findViewById<Button>(R.id.atrasi)
        botona.setOnClickListener {
            findNavController().navigate(R.id.action_informacionFragment_to_configuracionFragment)
        }

        val instainstagrambt=view.findViewById<ImageButton>(R.id.instagrambt)
        instainstagrambt.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.instagram.com/tienda_de_rosita5/")
            startActivity(openURL)
        }

    }

    override fun onMapReady(googleMap: GoogleMap) {
        map=googleMap
        marker()
    }

    private  fun marker(){
        val coordenadas= com.google.android.gms.maps.model.LatLng(4.411978, -76.156770)
        val marker: MarkerOptions = MarkerOptions().position(coordenadas).title("Tienda de Rosita")
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordenadas,18f),
            3000,
            null
        )

    }

}