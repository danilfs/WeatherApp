package com.example.weatherapp.data

import retrofit2.Callback


interface IDetailsRepository {
    fun getWeatherDetailsFromServer(lat: Double, lon: Double, callback: Callback<WeatherDTO>)
}