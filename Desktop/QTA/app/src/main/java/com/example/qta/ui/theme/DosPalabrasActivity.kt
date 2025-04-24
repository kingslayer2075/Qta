package com.example.QtA

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class DosPalabrasActivity : AppCompatActivity() {

    private lateinit var tvPalabras: TextView
    private lateinit var btnSolucionar: Button
    private lateinit var tvResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dos_palabras)

        tvPalabras = findViewById(R.id.tvPalabras)
        btnSolucionar = findViewById(R.id.btnSolucionar)
        tvResultado = findViewById(R.id.tvResultado)

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
    }
}