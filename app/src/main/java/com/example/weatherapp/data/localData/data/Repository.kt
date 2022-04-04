package com.example.weatherapp.data.localData.data

import com.example.weatherapp.data.localData.dto.Weather
import com.example.weatherapp.data.localData.dto.getRussianCities
import com.example.weatherapp.data.localData.dto.getWorldCities


class Repository : IRepository {
    override fun getWeatherFromServer(): Weather {
        return Weather()
    }

    override fun getWeatherFromLocalStorageRus(): List<Weather> = getRussianCities()

    override fun getWeatherFromLocalStorageWorld(): List<Weather> = getWorldCities()
}


