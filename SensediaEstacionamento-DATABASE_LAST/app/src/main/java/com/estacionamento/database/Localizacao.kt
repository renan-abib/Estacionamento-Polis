package com.example.databasesensedia

import androidx.room.Entity
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import java.util.*

@Entity (tableName = "localizacoes")
class Localizacao (@PrimaryKey (autoGenerate = true)
                   var id_localizacao: Int = 0,

                   @ColumnInfo(name = "latitude")
                   var latitude: String?,

                   @ColumnInfo(name = "longitude")
                   var longitude: String?){
}