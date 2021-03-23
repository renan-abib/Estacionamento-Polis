package com.estacionamento.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.text.trimmedLength
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.estacionamento.R
import com.estacionamento.databinding.LayoutActivityHomeBinding
import com.example.databasesensedia.MyDataBase
import kotlin.system.exitProcess


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: LayoutActivityHomeBinding
    lateinit var db : MyDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.layout_activity_home
        )

        val viewModel: HomeViewModel = ViewModelProviders.of(this).get(HomeViewModel ::class.java)

        viewModel.homeLiveData.observe(this, Observer {
            binding.inputPlacaCarro.text.toString()
        })

        //Esconde a Navigation bar e a Action bar do Android
        window.decorView.apply {
            systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                        View.SYSTEM_UI_FLAG_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }

        binding.buttonRetirarCarro.setOnClickListener{
            sendCar( binding.inputPlacaCarro.text.toString() )
        }

        binding.buttonDevolverCarro.setOnClickListener{
            sendCar( binding.inputPlacaCarro.text.toString() )
        }
    }

    private fun sendCar(placaCarro : String){
        if(validaPlaca(placaCarro) == false)
            Toast.makeText(this, "Placa Inválida", Toast.LENGTH_LONG).show()

        else
            startActivity(getMapIntent())
    }

    fun validaPlaca (placaCarro: String): Boolean {

        //verifica o tamanho da string para saber se o número de caracteres da placa está correto
        if (placaCarro.length != 7) {
            return false
        }

        //verifica se os 3 primeiros caracteres digitados são letras
        if (!placaCarro.get(0).isLetter() || !placaCarro.get(1).isLetter() || !placaCarro.get(2).isLetter()) {
            return false
        }

        //verifica se os quatro últimos caracteres digitados são números
        if (!placaCarro.get(3).isDigit() || !placaCarro.get(4).isDigit() || !placaCarro.get(5).isDigit() || !placaCarro.get(6).isDigit()) {
            return false
        }

        //retorna verdadeiro se perceber que a string tem o formato de uma placa
        return true
    }

    private fun getMapIntent() = Intent(MAP_INTENT)

    companion object{
        private const val MAP_INTENT = "com.estacionamento.map.START"
        private const val ACTION_TYPE_RETIRAR = "in"
        private const val ACTION_TYPE_DEVOLVER = "out"
    }
}