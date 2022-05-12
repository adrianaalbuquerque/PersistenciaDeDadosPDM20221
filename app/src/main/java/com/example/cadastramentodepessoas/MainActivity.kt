package com.example.cadastramentodepessoas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private lateinit var name: EditText
    private lateinit var idade: EditText
    private lateinit var cadastrar: Button
    private lateinit var listar: Button
    private lateinit var dao: PessoaDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.dao = PessoaDAO(this)

        this.name = findViewById(R.id.name)
        this.idade = findViewById(R.id.idade)
        this.cadastrar = findViewById(R.id.btnCadastrar)
        this.listar = findViewById(R.id.btnListar)

        this.cadastrar.setOnClickListener {
            salvar()
        }

        this.listar.setOnClickListener {
            listar()
        }
    }

    fun salvar() {
        val nome = this.name.text.toString()
        val idade = this.idade.text.toString().toInt()
        val pessoa = Pessoa(nome, idade)
        this.dao.insert(pessoa)
        Toast.makeText(this, "Pessoa cadastrada", Toast.LENGTH_SHORT).show()
    }

    fun listar() {
        Log.i("APP_CADASTRADOR", this.dao.select().toString())
    }
}