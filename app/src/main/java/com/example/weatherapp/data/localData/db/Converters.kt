package com.example.weatherapp.data.localData.db

import com.example.weatherapp.data.db.HistoryEntity
import com.example.weatherapp.data.localData.dto.City
import com.example.weatherapp.data.localData.dto.Weather

fun convertEntityToWeather(entityList: List<HistoryEntity>): List<Weather> =
    entityList.map {
        Weather(
            city = City(it.city, 0.0, 0.0), temperature = it.temperature, feelsLike = 0,
            condition = it.condition, id = it.id
        )
    }

fun convertWeatherToEntity(weather: Weather): HistoryEntity =
    HistoryEntity(
        0, weather.city?.city ?: "", weather.temperature,
        weather.condition
    )