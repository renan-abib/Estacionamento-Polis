package com.example.databasesensedia

import androidx.room.Entity
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import java.util.*

@Entity (tableName = "veiculos")
class Veiculo (

    @PrimaryKey (autoGenerate = true) var id_veiculo: Int = 0,

    @ColumnInfo(name = "chapa") var chapa: String?
)
}

    /*fun Veiculo(id_veiculo: Int, chapa: String) {
        this.id_veiculo = id_veiculo
        this.chapa = chapa
    }*/

