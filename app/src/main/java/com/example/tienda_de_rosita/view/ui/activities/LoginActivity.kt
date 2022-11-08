package com.example.tienda_de_rosita.view.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.tienda_de_rosita.R

class LoginActivity : AppCompatActivity() {
    lateinit var registo:Button
    lateinit var ingresar:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        registo= findViewById(R.id.registrate_log_bt)
        registo.setOnClickListener{
            startActivity(Intent(this, Registro::class.java))
        }

        val txtusuario = findViewById<EditText>(R.id.txtusuario)
        val txtpassword = findViewById<EditText>(R.id.txtpassword)
        ingresar=findViewById(R.id.ingresar_log_bt)

        ingresar.setOnClickListener {
            val usu = txtusuario.text.toString()
            val clave = txtpassword.text.toString()

            if (usu == "1" && clave == "1"){
                startActivity(Intent(this, home::class.java))
            }
            else if(usu== "1" && clave == "1"){
                startActivity(Intent(this, home::class.java))
            }
            else{
                Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show()
            }
        }

    }
}