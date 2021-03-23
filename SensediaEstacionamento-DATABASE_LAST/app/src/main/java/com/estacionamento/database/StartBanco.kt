package com.estacionamento.database

import com.example.databasesensedia.MyDataBase
import com.example.databasesensedia.VeiculoDao
import com.example.databasesensedia.Veiculo


class StartBanco {

    lateinit var db: MyDataBase
    lateinit var veiculoDao: VeiculoDao

    var veiculo1: Veiculo = Veiculo(1,"ABC1234")


   // db.MyDataBase.insert(veiculo1)

}
