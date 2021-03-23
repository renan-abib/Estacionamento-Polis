package com.estacionamento.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Helpers.insert
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.estacionamento.R
import com.estacionamento.databinding.LayoutActivityHomeBinding
import com.example.databasesensedia.MyDataBase
import com.example.databasesensedia.Veiculo
import com.example.databasesensedia.VeiculoLocalizacao
import kotlinx.android.synthetic.main.layout_activity_home.*
import kotlinx.android.synthetic.main.layout_database_list.*


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: LayoutActivityHomeBinding
    lateinit var db: MyDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.layout_activity_home
        )

        val viewModel: HomeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

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

        binding.buttonRetirarCarro.setOnClickListener {
            sendCar(binding.inputPlacaCarro.text.toString())
        }

        binding.buttonDevolverCarro.setOnClickListener {
            sendCar(binding.inputPlacaCarro.text.toString())
        }
    }

    private fun sendCar(placaCarro: String) {
        if (consulta(placaCarro) == false)
            Toast.makeText(this, "Placa não cadastrada", Toast.LENGTH_LONG).show()
        else
            startActivity(getMapIntent())
    }

    private fun getMapIntent() = Intent(MAP_INTENT)

    companion object {
        private const val MAP_INTENT = "com.estacionamento.map.START"
        private const val ACTION_TYPE_RETIRAR = "in"
        private const val ACTION_TYPE_DEVOLVER = "out"
    }



    private fun devolvercarro(veiculo: Veiculo){

    button_Devolver_Carro.setOnClickListener {


        var button_Devolver_Carro = VeiculoLocalizacao(id_veiculo, chapa, id_localizacao)
        val veiculoChapa = input_placa_carro.text.toString().trim()

        if (veiculoChapa.isEmpty()) {
            input_placa_carro.error = "chapa requerida"
            input_placa_carro.requestFocus()
            return@setOnClickListener
        }
    }
        db.VeiculoLocalizacaoDao().insert(chapa)
    }

    private fun insertPlacasFake (){
        db.VeiculoLocalizacaoDao().insert("AAA 0A00")
        db.VeiculoLocalizacaoDao().insert("SSD 1A01")
        db.VeiculoLocalizacaoDao().insert("SSD 2B02")
        db.VeiculoLocalizacaoDao().insert("SSD 3C03")
        db.VeiculoLocalizacaoDao().insert("SSD 4D04")
        db.VeiculoLocalizacaoDao().insert("SSD 5E05")
        db.VeiculoLocalizacaoDao().insert("SSD 6F06")
        db.VeiculoLocalizacaoDao().insert("SSD 7G07")
        db.VeiculoLocalizacaoDao().insert("SSD 8H08")
        db.VeiculoLocalizacaoDao().insert("SSD 9I09")
    }



   //MyDataBase(activity!!).getVeiculoDao()

/*    fun consulta(placaCarro: String) {
        Thread(Runnable {
            val veiculos = db.veiculoDao().getAll()
            for(veiculo: Veiculo in veiculos){

                Log.i("Registro", " Chapa " + veiculo.chapa)
            }
        }).start()
    }
*/

    /*fun validaPlaca(placaCarro: String): Boolean {

        //verifica o tamanho da string para saber se o número de caracteres da placa está correto
        if (placaCarro.length != 7) {
            return false
        }

        //verifica se os 3 primeiros caracteres digitados são letras
        if (!placaCarro.get(0).isLetter() || !placaCarro.get(1).isLetter() || !placaCarro.get(2)
                .isLetter()
        ) {
            return false
        }

        //verifica se os quatro últimos caracteres digitados são números
        if (!placaCarro.get(3).isDigit() || !placaCarro.get(4).isDigit() || !placaCarro.get(5)
                .isDigit() || !placaCarro.get(6).isDigit()
        ) {
            return false
        }

        //retorna verdadeiro se perceber que a string tem o formato de uma placa
        return true
    }*/



}
    /* Lógica do Banco
    cadastrar.setOnClickListener{
        var button_Devolver_Carro = Veiculo_x_Localizacao(id_veiculo, chapa, id_localizacao)
        Thread(Runnable {
            db.Veiculo_x_LocalizacaoDao().insert(veiculo)
            runOnUiThread{
                nome.setText("")
                nascimento.text = "Selecione uma data"
                consulta()
            }
        }).start()
    }

}
/*
fun consulta() {
    Thread(Runnable {
        var usuarios = db.usuasioDao().getAll()
        var format= SimpleDateFormat("dd/MM/yyyy")
        for(user:Usuario in usuarios){

            Log.i("Registro", " nome " + user.nome + " nascimento " + format.format(user.nascimento) + " id " + user.id)
        }
    }).start()
}
*/
     */