package com.example.tp01_01

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editNome = findViewById<EditText>(R.id.editNome)
        val editIdade = findViewById<EditText>(R.id.editIdade)
        val btnConfirmar = findViewById<Button>(R.id.buttonConfirmar)
        val txtSaudacao = findViewById<TextView>(R.id.txtSaudacao)

        btnConfirmar.setOnClickListener {
            val nomeStr = editNome.text.toString()
            val idadeStr = editIdade.text.toString().toInt()

            when {
                nomeStr != "" && idadeStr > 0 ->
                    txtSaudacao.text = "Olá, $nomeStr. Você tem $idadeStr anos!"
                else ->
                    txtSaudacao.text = "Preencha os campos corretamente!"
            }
        }
    }
}