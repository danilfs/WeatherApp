package com.example.weatherapp.data.localData.db

import com.example.weatherapp.data.localData.dto.Weather

interface IDbRepository {
    fun getAllHistory(): List<Weather>
    fun saveEntity(weather: Weather)
}