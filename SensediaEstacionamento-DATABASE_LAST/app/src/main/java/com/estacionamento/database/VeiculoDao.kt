package com.example.databasesensedia

import androidx.room.*

@Dao
interface VeiculoDao {

    @Query("SELECT * FROM veiculos")
    fun getAllVeiculos(): List<Veiculo>
//    @Query("SELECT * FROM veiculos WHERE chapa = :paramchapa limit 1")
//    fun findByName(paramchapa: String): Veiculo

    @Insert
    fun insertAllVeiculos(vararg veiculos: Veiculo)

    @Insert
    fun insertVeiculo(veiculo: Veiculo)
//    @Delete
//    fun delete(veiculo: Veiculo)
//    @Update
//    fun update(veiculo: Veiculo)
}