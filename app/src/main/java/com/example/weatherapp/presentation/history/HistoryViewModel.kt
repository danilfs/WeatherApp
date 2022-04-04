package com.example.weatherapp.presentation.history

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.App.Companion.getHistoryDao
import com.example.weatherapp.data.localData.db.DbRepository
import com.example.weatherapp.data.localData.db.IDbRepository
import com.example.weatherapp.data.states.AppState

class HistoryViewModel(
    val historyLiveData: MutableLiveData<AppState> = MutableLiveData(),
    private val historyRepository: IDbRepository =
        DbRepository(getHistoryDao())
) : ViewModel() {
    fun getAllHistory() {
        historyLiveData.postValue(AppState.Loading)
        historyLiveData.postValue(
            AppState.Success(historyRepository.getAllHistory())
        )
    }

}