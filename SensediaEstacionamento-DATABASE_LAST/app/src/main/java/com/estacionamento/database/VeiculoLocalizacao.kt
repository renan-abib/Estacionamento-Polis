package com.example.databasesensedia

import androidx.room.*
import java.time.LocalDateTime


@Entity (tableName = "veiculolocalizacao")
class VeiculoLocalizacao(@PrimaryKey (autoGenerate = true)
                            var id_veiculo_localizacao: Int = 0,

                         @ForeignKey (
                                entity = VeiculoLocalizacao::class, parentColumns = arrayOf("id_veiculo"),
                                childColumns = arrayOf("chapa", "id_localizacao"))

                            @ColumnInfo(name = "data_devolucao")
                            var data_devolucao: LocalDateTime?)