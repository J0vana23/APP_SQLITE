package com.example.apprevisao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.apprevisao.db.DBHelper

class RespostaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resposta)

        // Referência aos campos de entrada do layout
        val edtNome: EditText = findViewById(R.id.edtNome)
        val edtEndereco: EditText = findViewById(R.id.edtEndereco)
        val edtBairro: EditText = findViewById(R.id.edtBairro)
        val edtCep: EditText = findViewById(R.id.edtCep)
        val edtObservacao:EditText = findViewById(R.id.edtObservacao)
        val edtData:EditText = findViewById(R.id.edtData)

        // Referência ao botão de confirmação
        val btnConfirmar:Button = findViewById(R.id.btnConfirmar)

        // Preenche os campos com os dados recebidos da MainActivity via Intent
        edtNome.setText(intent.getStringExtra("nome"))
        edtEndereco.setText(intent.getStringExtra("endereco"))
        edtBairro.setText(intent.getStringExtra("bairro"))
        edtCep.setText(intent.getStringExtra("cep"))
        edtObservacao.setText(intent.getStringExtra("observacao"))
        edtData.setText(intent.getStringExtra("data"))

        // Instancia o helper do banco de dados SQLite
        val db = DBHelper(this, null)

        // Ao clicar no botão, salva os dados no banco e encerra a atividade
        btnConfirmar.setOnClickListener {
            db.addPessoa(
                edtNome.text.toString(),
                edtEndereco.text.toString(),
                edtBairro.text.toString(),
                edtCep.text.toString(),
                edtObservacao.text.toString(),
                edtData.text.toString())
            finish()
        }
    }
}