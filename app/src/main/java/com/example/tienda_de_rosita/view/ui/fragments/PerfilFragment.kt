package com.example.tienda_de_rosita.view.ui.fragments

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.findFragment
import androidx.navigation.fragment.findNavController
import com.example.tienda_de_rosita.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class PerfilFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_perfil, container, false)
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btm = view.findViewById<BottomNavigationView>(R.id.buttonNavigationMenu)
        btm.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.configuracionm -> findNavController().navigate(R.id.action_perfilFragment_to_configuracionFragment)
                R.id.homem -> findNavController().navigate(R.id.action_perfilFragment_to_menuFragment)
                R.id.carritom -> findNavController().navigate(R.id.action_perfilFragment_to_carritoFragment)
            }
        }
        val botona=view.findViewById<Button>(R.id.atrasp)
        botona.setOnClickListener{
            findNavController().navigate(R.id.action_perfilFragment_to_configuracionFragment)
        }

        val btmcamara=view.findViewById<Button>(R.id.buttoncamara)
        btmcamara.setOnClickListener{
            val intent=Intent(MediaStore.ACTION_IMAGE_CAPTURE )
            startActivityForResult(intent,123)
        }
        val btmgaleria=view.findViewById<Button>(R.id.buttongaleria)
        btmgaleria.setOnClickListener{
            val intent=Intent(Intent.ACTION_PICK)
            intent.type="image/*"
            startActivityForResult(intent, 456)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val imagenView=view?.findViewById<ImageView>(R.id.perfilfotoo)
        if (requestCode==123){
            var bitmap=data?.extras?.get("data") as Bitmap
            imagenView?.setImageBitmap(bitmap)
        }else if (requestCode==456){
            imagenView?.setImageURI(data?.data)
        }
    }
}