package com.example.weatherapp.data.details

import com.example.weatherapp.data.localData.dto.WeatherDTO
import retrofit2.Callback


interface IDetailsRepository {
    fun getWeatherDetailsFromServer(lat: Double, lon: Double, callback: Callback<WeatherDTO>)
}