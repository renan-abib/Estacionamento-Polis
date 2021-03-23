package com.estacionamento.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel() : ViewModel() {

    val homeLiveData: MutableLiveData<String> = MutableLiveData()

}