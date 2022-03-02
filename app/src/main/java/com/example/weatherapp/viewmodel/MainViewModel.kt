package com.example.weatherapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.data.IRepository
import com.example.weatherapp.data.Repository
import com.example.weatherapp.data.AppState
import java.lang.Thread.sleep

class MainViewModel (private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData(),
                     private val repository : IRepository = Repository()
) : ViewModel() {
    fun getLiveData() = liveDataToObserve

    fun getWeatherFromLocalSource() = getDataFromLocalSource()

    fun getWeatherFromRemoteSource() = getDataFromLocalSource()

    private fun getDataFromLocalSource() {
        liveDataToObserve.postValue(AppState.Loading)
        Thread {
            sleep(1000)
            liveDataToObserve.postValue(AppState.Success(repository.getWeatherFromLocalStorage()))
        }.start()
    }
}
