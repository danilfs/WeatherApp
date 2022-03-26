package com.example.weatherapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.data.AppState
import com.example.weatherapp.data.IRepository
import com.example.weatherapp.data.Repository
import java.lang.Thread.sleep

class MainViewModel(
    private val mutableLiveData: MutableLiveData<AppState> = MutableLiveData(),
    private val repository: IRepository = Repository()
) :
    ViewModel() {

    val liveData: LiveData<AppState> get() = mutableLiveData

    fun getWeatherFromLocalSourceRus() = getDataFromLocalSource(isRussian = true)

    fun getWeatherFromLocalSourceWorld() = getDataFromLocalSource(isRussian = false)

    fun getWeatherFromRemoteSource() = getDataFromLocalSource(isRussian = true)

    private fun getDataFromLocalSource(isRussian: Boolean) {
        mutableLiveData.postValue(AppState.Loading)
        Thread {
            sleep(3000)
            mutableLiveData.postValue(AppState.Success(
                if (isRussian) repository.getWeatherFromLocalStorageRus()
                else repository.getWeatherFromLocalStorageWorld()
            )
            )
        }.start()
    }
}
