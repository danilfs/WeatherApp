package com.example.weatherapp.data.localData.data

import com.example.weatherapp.data.localData.dto.Weather


interface IRepository {
    fun getWeatherFromServer(): Weather
    fun getWeatherFromLocalStorageRus(): List<Weather>
    fun getWeatherFromLocalStorageWorld(): List<Weather>
}