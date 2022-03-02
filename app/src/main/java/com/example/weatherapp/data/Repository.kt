package com.example.weatherapp.data

class Repository : IRepository {
    override fun getWeatherFromServer(): Weather {
    return Weather()
    }

    override fun getWeatherFromLocalStorage(): Weather {
        return Weather()
    }

}