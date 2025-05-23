package com.example.QtA

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.QtA.R

class QuitarFragmentoActivity : AppCompatActivity() {

    private lateinit var tvPalabras: TextView
    private lateinit var btnSolucionar: Button
    private lateinit var tvResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quitar_fragmento)

        tvPalabras = findViewById(R.id.tvPalabras)
        btnSolucionar = findViewById(R.id.btnSolucionar)
        tvResultado = findViewById(R.id.tvResultado)
        btnSolucionar.setOnClickListener {
            val cadenaIngresada = tvPalabras.text.toString()
            val resultado = eliminarEntreHs(cadenaIngresada)

            tvResultado.text = resultado
        }
    }

    private fun eliminarEntreHs(cadena: String): String {
        val indicesH = mutableListOf<Int>()
        for ((index, char) in cadena.withIndex()) {
            if (char == 'h') {
                indicesH.add(index)
            }
        }

        return if (indicesH.size >= 2) {
            cadena.substring(0, indicesH.first()) + cadena.substring(indicesH.last() + 1)
        } else {
            "error"
        }
    }
}