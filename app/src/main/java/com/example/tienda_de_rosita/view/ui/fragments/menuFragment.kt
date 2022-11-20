package com.example.tienda_de_rosita.view.ui.fragments

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
import com.example.tienda_de_rosita.model.productos
import com.example.tienda_de_rosita.view.adapter.OnBookItemClickListener
import com.example.tienda_de_rosita.view.adapter.ProductosAdapter
import com.example.tienda_de_rosita.viewmodel.ProductViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase


class menuFragment : Fragment(), OnBookItemClickListener {

    lateinit var recyclerProduc: RecyclerView
    lateinit var firebaseAuth: FirebaseAuth
    lateinit var adapter: ProductosAdapter
    val database: FirebaseFirestore=FirebaseFirestore.getInstance()
    private val viewmodel by lazy{ViewModelProvider(this).get(ProductViewModel::class.java)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firebaseAuth= Firebase.auth

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view =inflater.inflate(R.layout.fragment_menu, container, false)
        recyclerProduc= view.findViewById(R.id.recyclerview)
        adapter=ProductosAdapter(requireContext(), this)
        recyclerProduc.layoutManager= LinearLayoutManager(context)
        recyclerProduc.adapter=adapter
        observeData()
        return view

    }

    fun observeData(){
        viewmodel.productData().observe(viewLifecycleOwner, Observer {
            adapter.setListData(it)
            adapter.notifyDataSetChanged()
        })
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
        val btmagre= view.findViewById<TextView>(R.id.agregarp)
        btmagre.setOnClickListener{
            findNavController().navigate(R.id.action_menuFragment_to_agregarPFragment)
        }
    }

    override fun onItemclick(producto: productos, position: Int) {
        val titulo:String=producto.titulo
        val precio:String=producto.precio
        val image:String=producto.imagen
        val dato= hashMapOf(
            "titulo" to titulo,
            "precio" to precio,
            "image" to image
        )
        database.collection("compras")
            .document(titulo)
            .set(dato)
            .addOnSuccessListener {
                Toast.makeText(context,"producto añadido al carrito", Toast.LENGTH_SHORT).show()
            }
    }
}
            /*
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
            */




