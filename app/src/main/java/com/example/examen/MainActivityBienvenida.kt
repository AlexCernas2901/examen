// MainActivityBienvenida.kt
package com.example.examen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.examen.databinding.ActivityMainBienvenidaBinding

class MainActivityBienvenida : AppCompatActivity() {
    private lateinit var binding: ActivityMainBienvenidaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBienvenidaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nombre = intent.getStringExtra("nombre")
        val apellidos = intent.getStringExtra("apellidos")

        binding.txvBienvenida.text = "Bienvenido $nombre $apellidos"

        binding.btnSalir.setOnClickListener {
            finish()
        }
    }
}