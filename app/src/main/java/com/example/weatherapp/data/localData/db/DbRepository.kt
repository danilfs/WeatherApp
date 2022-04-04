package com.example.weatherapp.data.localData.db

import com.example.weatherapp.data.db.HistoryDao
import com.example.weatherapp.data.localData.dto.Weather

class DbRepository(private val dataSource: HistoryDao): IDbRepository {
    override fun getAllHistory(): List<Weather> =
        convertEntityToWeather(dataSource.all())

    override fun saveEntity(weather: Weather) {
        dataSource.insert(convertWeatherToEntity(weather))
    }
}