package com.example.tienda_de_rosita.view.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.tienda_de_rosita.R
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import java.lang.ref.PhantomReference

class Registro : AppCompatActivity() {
    lateinit var buttonregistro:Button
    private lateinit var nombre:EditText
    private lateinit var apellidos:EditText
    private lateinit var telefono:EditText
    private lateinit var usuario:EditText
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var dbReference: DatabaseReference
    private lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        firebaseAuth= Firebase.auth
        database=FirebaseDatabase.getInstance()
        dbReference=database.reference.child("Usuario")

        buttonregistro=findViewById(R.id.registrate_registro_bt)
        nombre=findViewById(R.id.nombresregistro)
        apellidos=findViewById(R.id.apellidosregistro)
        val correo=findViewById<EditText>(R.id.correoregistro)
        telefono=findViewById(R.id.telefonoregistro)
        usuario=findViewById(R.id.usuarioregistro)
        val contrasena=findViewById<EditText>(R.id.contraseñaregistro)
        buttonregistro.setOnClickListener{
            crearcuenta(correo.text.toString(), contrasena.text.toString())
        }
    }
    private fun crearcuenta(correo:String, contrasena:String){
        val namen:String=nombre.text.toString()
        val namea:String=apellidos.text.toString()
        val namet:String=telefono.text.toString()
        val nameu:String=usuario.text.toString()

        firebaseAuth.createUserWithEmailAndPassword(correo, contrasena)
            .addOnCompleteListener(this){
                Task->if(Task.isSuccessful){
                    val user=firebaseAuth.currentUser
                    val userdb=dbReference.child(user?.uid.toString())
                    userdb.child("Nombres").setValue(namen)
                    userdb.child("Apellidos").setValue(namea)
                    userdb.child("Telefono").setValue(namet)
                    userdb.child("Usuario").setValue(nameu)
                    Toast.makeText(baseContext, "Cuenta creada con exito",Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, home::class.java))
            }else{
                Toast.makeText(baseContext, "Error verifique los datos", Toast.LENGTH_SHORT).show()
            }
            }
    }
}