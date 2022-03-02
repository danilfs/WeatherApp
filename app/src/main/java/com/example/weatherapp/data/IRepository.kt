package com.example.weatherapp.data

interface IRepository {
    fun getWeatherFromServer() : Weather
    fun getWeatherFromLocalStorage () : Weather
}