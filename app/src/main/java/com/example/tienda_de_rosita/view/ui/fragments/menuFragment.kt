package com.example.tienda_de_rosita.view.ui.fragments

import android.content.ClipData.Item
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tienda_de_rosita.R
import com.example.tienda_de_rosita.view.adapter.ProductosAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView


class menuFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_menu, container, false)
        return view
    }


        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            val btm = view.findViewById<BottomNavigationView>(R.id.buttonNavigationMenu)
            btm.setOnNavigationItemReselectedListener {
                when (it.itemId) {
                    R.id.configuracionm -> findNavController().navigate(R.id.action_menuFragment_to_configuracionFragment)
                    R.id.homem -> findNavController().navigate(R.id.action_menuFragment_self)
                    R.id.carritom -> findNavController().navigate(R.id.action_menuFragment_to_carritoFragment)
                }
            }
            val btmpt=view.findViewById<Button>(R.id.buttonTortaFria)
            btmpt.setOnClickListener{
                findNavController().navigate(R.id.action_menuFragment_to_tortaFragment)
            }
            val btmpv=view.findViewById<Button>(R.id.buttonVolcan)
            btmpv.setOnClickListener{
                findNavController().navigate(R.id.action_menuFragment_to_volcanFragment)
            }
            val btmpp=view.findViewById<Button>(R.id.buttonPudin)
            btmpp.setOnClickListener{
                findNavController().navigate(R.id.action_menuFragment_to_pudinFragment)
            }
            val btmppu=view.findViewById<Button>(R.id.buttonPieDeLimon)
            btmppu.setOnClickListener{
                findNavController().navigate(R.id.action_menuFragment_to_pieFragment)
            }
            val btmpar=view.findViewById<Button>(R.id.buttonParfait)
            btmpar.setOnClickListener{
                findNavController().navigate(R.id.action_menuFragment_to_parfaitFragment)
            }
            val btmmuf=view.findViewById<Button>(R.id.buttonMuffin)
            btmmuf.setOnClickListener{
                findNavController().navigate(R.id.action_menuFragment_to_muffinFragment)
            }
            val btmg=view.findViewById<Button>(R.id.buttonGelatina)
            btmg.setOnClickListener{
                findNavController().navigate(R.id.action_menuFragment_to_gelatinaFragment)
            }
            val btmga=view.findViewById<Button>(R.id.buttonGalletas)
            btmga.setOnClickListener{
                findNavController().navigate(R.id.action_menuFragment_to_galletasFragment)
            }
            val btmf=view.findViewById<Button>(R.id.buttonFresas)
            btmf.setOnClickListener{
                findNavController().navigate(R.id.action_menuFragment_to_fresasFragment)
            }
            val btmbt=view.findViewById<Button>(R.id.buttonBatido)
            btmbt.setOnClickListener{
                findNavController().navigate(R.id.action_menuFragment_to_batidoFragment)
            }


        }
    }




