package com.example.saudeja12301256

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val estoqueMedicamentos = mapOf(
        "Paracetamol" to true,
        "Ibuprofeno" to true,
        "Amoxicilina" to true,
        "Dipirona" to true,
        "Azitromicina" to false,
        "Aspirina" to false
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn_consulta = findViewById<Button>(R.id.btn_consultar)
        btn_consulta.setOnClickListener {
            consulta()
        }
    }


    fun consulta() {
        val tv_resultado = findViewById<TextView>(R.id.tv_resul)
        val remEditText = findViewById<EditText>(R.id.edt_rem)
        val rem = remEditText.text.toString()

        if (estoqueMedicamentos.containsKey(rem)) {
            val disponibilidade = if (estoqueMedicamentos[rem] == true) {
                "$rem está disponível em estoque"
            } else {
                "$rem não está disponível em estoque"
            }
            tv_resultado.setText(" ${disponibilidade} ")
        } else {
            tv_resultado.setText("Medicamento não encontrado")
        }
    }
}
