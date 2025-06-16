package com.example.apprevisao

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referência aos campos de entrada do layout
        val edtNome:EditText = findViewById(R.id.edtNome)
        val edtEndereco:EditText = findViewById(R.id.edtEndereco)
        val edtBairro:EditText = findViewById(R.id.edtBairro)
        val edtCep:EditText = findViewById(R.id.edtCep)
        val edtObservacao:EditText = findViewById(R.id.edtObservacao)
        val edtData:EditText = findViewById(R.id.edtData)

        // Referência ao botão de cadastro
        val btnCadastrar:Button = findViewById(R.id.btnCadastrar)

        // Ação ao clicar no botão
        btnCadastrar.setOnClickListener {
            val intent = Intent(this, RespostaActivity::class.java)

            // Passa os dados inseridos nos campos para a próxima atividade
            intent.putExtra("nome",edtNome.text.toString())
            intent.putExtra("endereco",edtEndereco.text.toString())
            intent.putExtra("bairro",edtBairro.text.toString())
            intent.putExtra("cep",edtCep.text.toString())
            intent.putExtra("observacao",edtObservacao.text.toString())
            intent.putExtra("data",edtData.text.toString())

            startActivity(intent)
        }
    }
}