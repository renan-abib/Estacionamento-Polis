package com.estacionamento.map

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.estacionamento.R
import com.estacionamento.databinding.LayoutActivityTestBinding

class MapActivity : AppCompatActivity() {

    private lateinit var binding: LayoutActivityTestBinding

    private var actionType : String? = null

    private var carId : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.layout_activity_test
        )
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

        loadDataFromIntent(intent)
        loadFeatures()
        binding.teste.text = carId
    }

    private fun loadDataFromIntent(intent: Intent?){
        //Criar LOGS para essas coisas
        //actionType = intent?.getStringExtra(ACTION_TYPE)
        //carId = intent?.getStringExtra(CARD_ID)
    }

    private fun loadFeatures(){

    }
}
