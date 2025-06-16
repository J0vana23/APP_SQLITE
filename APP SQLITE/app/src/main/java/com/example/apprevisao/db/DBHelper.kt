package com.example.apprevisao.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// Classe responsável por gerenciar o banco de dados SQLite
class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    // Método chamado na criação do banco de dados
    override fun onCreate(db: SQLiteDatabase) {

        // Query SQL para criar a tabela com suas colunas e tipos de dados
        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY, " +
                NAME_COL + " TEXT," +
                END_COL + " TEXT," +
                BAR_COL + " TEXT," +
                CEP_COL + " TEXT," +
                OBV_COL + " TEXT," +
                DAT_COL + " TEXT" + ")")

        // Executa a query no banco de dados
        db.execSQL(query)
    }

    // Método chamado quando há necessidade de atualizar o banco (versão diferente)
    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        // Remove a tabela existente, se houver
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        // Cria novamente a tabela
        onCreate(db)
    }

    // Função para inserir uma nova pessoa no banco de dados
    fun addPessoa(name : String, endereco : String, bairro : String, cep : String, observacao : String, data : String  ){

        // Cria um objeto ContentValues para armazenar os dados como pares chave-valor
        val values = ContentValues()

        // Insere os dados recebidos nos respectivos campos
        values.put(NAME_COL, name)
        values.put(END_COL, endereco)
        values.put(BAR_COL, bairro)
        values.put(CEP_COL, cep)
        values.put(OBV_COL, observacao)
        values.put(DAT_COL, data)

        // Obtém uma instância do banco em modo escrita
        val db = this.writableDatabase

        // Insere os dados na tabela
        db.insert(TABLE_NAME, null, values)

        // Fecha o banco de dados
        db.close()
    }

    companion object{

        // Nome do banco de dados
        private val DATABASE_NAME = "appSQLite"

        // Versão do banco de dados
        private val DATABASE_VERSION = 1

        // Nome da tabela
        val TABLE_NAME = "CadastroPessoa"

        // Nome das colunas da tabela
        val ID_COL = "id"
        val NAME_COL = "name"
        val END_COL = "endereco"
        val BAR_COL = "bairro"
        val CEP_COL = "cep"
        val OBV_COL = "observacao"
        val DAT_COL = "data"
    }
}