package com.example.databasesensedia

import androidx.room.*

@Dao
interface LocalizacaoDao {

    @Query("SELECT * FROM localizacoes")
    fun getAll(): List<Localizacao>
    @Query("SELECT * FROM localizacoes WHERE id_localizacao = :paramNome limit 1")
    fun findByName(paramNome: String): Localizacao
    @Insert
    fun insertAll(vararg localizacoes: Localizacao)
    @Insert
    fun insert(localizacao: Localizacao)
    @Delete
    fun delete(localizacao: Localizacao)
    @Update
    fun update(localizacao: Localizacao)

}