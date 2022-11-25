package com.example.tienda_de_rosita.view.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.tienda_de_rosita.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    lateinit var registo:Button
    lateinit var ingresar:Button
    private lateinit var firebaseAuth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        firebaseAuth= Firebase.auth

        registo= findViewById(R.id.registrate_log_bt)
        ingresar= findViewById(R.id.ingresar_log_bt)
        val txtusuario = findViewById<EditText>(R.id.txtusuario)
        val txtpassword = findViewById<EditText>(R.id.txtpassword)

        registo.setOnClickListener{
            startActivity(Intent(this, Registro::class.java))
        }
        ingresar.setOnClickListener{
            login(txtusuario.text.toString(), txtpassword.text.toString())
        }
    }


    private  fun login(correo:String, contrasena:String) {
        firebaseAuth.signInWithEmailAndPassword(correo, contrasena)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = firebaseAuth.currentUser
                    Toast.makeText(baseContext, "Ingreso exitoso", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, home::class.java))
                } else {
                    Toast.makeText(baseContext, "Datos Erroneos", Toast.LENGTH_SHORT).show()
                }
            }
    }

}