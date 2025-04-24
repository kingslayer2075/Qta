package com.example.QtA

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class DosPalabrasActivity : AppCompatActivity() {

    private lateinit var tvPalabras: TextView
    private lateinit var btnSolucionar: Button
    private lateinit var tvResultado: TextView
    private lateinit var btnMitades: ImageView
    private lateinit var btnPalabras: ImageView
    private lateinit var btnFragmentos: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dos_palabras)

        tvPalabras = findViewById(R.id.tvPalabras)
        btnSolucionar = findViewById(R.id.btnSolucionar)
        tvResultado = findViewById(R.id.tvResultado)

        btnMitades = findViewById(R.id.btnMitades)
        btnPalabras = findViewById(R.id.btnPalabras)
        btnFragmentos = findViewById(R.id.btnFragmentos)

        btnSolucionar.setOnClickListener {
            val cadenaIngresada = tvPalabras.text.toString()
            val palabras = cadenaIngresada.split(" ")

            if (palabras.size == 2) {
                val palabra1 = palabras[0]
                val palabra2 = palabras[1]
                val resultado = "$palabra2 $palabra1"
                tvResultado.text = resultado
            } else {
                Toast.makeText(this, "Por favor, ingresa exactamente 2 palabras separadas por un espacio.", Toast.LENGTH_LONG).show()
                tvResultado.text = ""
            }
        }

        btnMitades.setOnClickListener {
            startActivity(Intent(this, DosMitadesActivity::class.java))
        }

        btnPalabras.setOnClickListener {
            Toast.makeText(this, "Ya estás en Dos Palabras.", Toast.LENGTH_SHORT).show()
        }

        btnFragmentos.setOnClickListener {
            startActivity(Intent(this, QuitarFragmentoActivity::class.java))
        }
    }
}
