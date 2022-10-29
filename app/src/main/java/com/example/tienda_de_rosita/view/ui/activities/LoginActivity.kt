package com.example.tienda_de_rosita.view.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.tienda_de_rosita.R

class LoginActivity : AppCompatActivity() {
    lateinit var registro:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        registro=findViewById(R.id.registrate_log_bt)
        registro.setOnClickListener{
            startActivity(Intent(this, Registro::class.java))
        }
        var txtusuario = findViewById<EditText>(R.id.txtusuario)
        var txtpassword = findViewById<EditText>(R.id.txtpassword)
        val ingresar_log_bt = findViewById<Button>(R.id.ingresar_log_bt)
        ingresar_log_bt.setOnClickListener{
            var usu = txtusuario.text.toString()
            var clave = txtpassword.text.toString()
            println(usu)
            if (usu == "3116345115" && clave == "12345") {
                startActivity(Intent(this, home::class.java))
            }
            else if (usu == "persona@gmail.com" && clave == "12345"){
                startActivity(Intent(this, home::class.java))
            }
            else {
                Toast.makeText(this, "Datos Incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}