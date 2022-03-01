package com.example.weatherapp.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

class MainViewModel (private val liveDataToObserve: MutableLiveData<Any> = MutableLiveData()) : ViewModel() {
    fun getLiveData() = liveDataToObserve

}