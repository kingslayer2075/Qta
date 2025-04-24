package com.example.QtA

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class DosMitadesActivity : AppCompatActivity() {

    private lateinit var tvPalabras: TextView
    private lateinit var btnSolucionar: Button
    private lateinit var tvResultado: TextView

    private lateinit var btnMitades: LinearLayout
    private lateinit var btnPalabras: LinearLayout
    private lateinit var btnFragmentos: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dos_mitades)

        tvPalabras = findViewById(R.id.tvPalabras)
        btnSolucionar = findViewById(R.id.btnSolucionar)
        tvResultado = findViewById(R.id.tvResultado)

        btnMitades = findViewById(R.id.btnMitades)
        btnPalabras = findViewById(R.id.btnPalabras)
        btnFragmentos = findViewById(R.id.btnFragmento)

        btnSolucionar.setOnClickListener {
            val cadenaIngresada = tvPalabras.text.toString()
            val resultado = intercambiarMitades(cadenaIngresada)
            tvResultado.text = resultado
        }

        btnMitades.setOnClickListener {
            // Ya estás aquí
        }

        btnPalabras.setOnClickListener {
            startActivity(Intent(this, DosPalabrasActivity::class.java))
        }

        btnFragmentos.setOnClickListener {
            startActivity(Intent(this, QuitarFragmentoActivity::class.java))
        }
    }

    private fun intercambiarMitades(cadena: String): String {
        val longitud = cadena.length
        if (longitud <= 1) {
            return cadena
        }
        val mitad = (longitud + 1) / 2
        val primeraMitad = cadena.substring(0, mitad)
        val segundaMitad = cadena.substring(mitad)
        return segundaMitad + primeraMitad
    }
}
