package com.example.databasesensedia

import androidx.room.*

@Dao
interface VeiculoLocalizacaoDao {

    @Query("SELECT * FROM veiculolocalizacao")
    fun getAll(): List<VeiculoLocalizacao>
    //@Query("SELECT * FROM veiculolocalizacao WHERE id_veiculo_localizacao = :paramNome limit 1")
    //fun findByName(paramNome: String): VeiculoLocalizacao
    //@Insert
    //fun insertAll(vararg veiculolocalizacao: VeiculoLocalizacao)
    @Insert
    fun insert(veiculolocalizacao: VeiculoLocalizacao)
    //@Delete
    //fun delete(veiculolocalizacao: VeiculoLocalizacao)
    //@Update
    //fun update(veiculolocalizacao: VeiculoLocalizacao)
}