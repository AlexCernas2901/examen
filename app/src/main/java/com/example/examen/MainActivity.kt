// MainActivity.kt
package com.example.examen

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.examen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    // Persona.kt
    data class Persona(val nombre: String, val apellidos: String)

    // UserData.kt
    object UserData {
        val username = "acernas1"
        val password = "Mypass123"
        val personas = listOf(Persona("Angel Alexis", "Cernas Hernandez"))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEntrar.setOnClickListener {
            val user = binding.edtLogin.text.toString()
            val pass = binding.edtPassword.text.toString()

            if (user.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "No puede haber campos vacíos", Toast.LENGTH_SHORT).show()
            } else if (user == UserData.username && pass == UserData.password) {
                val intent = Intent(this, MainActivityBienvenida::class.java)
                intent.putExtra("nombre", UserData.personas[0].nombre)
                intent.putExtra("apellidos", UserData.personas[0].apellidos)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}