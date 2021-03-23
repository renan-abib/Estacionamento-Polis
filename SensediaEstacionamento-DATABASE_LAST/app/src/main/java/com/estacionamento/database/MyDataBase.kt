package com.example.databasesensedia

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = arrayOf(Veiculo::class), arrayOf(Localizacao::class), arrayOf(VeiculoLocalizacao::class), version = 1)
abstract class MyDataBase : RoomDatabase(){
    abstract fun getVeiculoDao(): VeiculoDao
    abstract fun getLocalizacaoDao(): LocalizacaoDao
    abstract fun getVeiculoLocalizacaoDao(): VeiculoLocalizacaoDao
    abstract fun VeiculoLocalizacaoDao(): VeiculoLocalizacaoDao

    companion object {

      @Volatile  private var instance: MyDataBase? = null

        private val LOCK = Any()

        operator fun invoke(context: Context) = invoke ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { it: MyDataBase
            instance = it}



        }

        private fun buildDatabase(context: Context ): Builder<MyDataBase> {
            val name
            return Room.databaseBuilder(
                context.applicationContext,
                MyDataBase::class.java,
                name:"mydatabase"
            ).build()
    }
}