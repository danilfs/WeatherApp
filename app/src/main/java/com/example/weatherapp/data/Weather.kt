package com.example.weatherapp.data

data class Weather(val city: City = getDefaultCity(),
                   val temperature : Int = 0,
                   val feelsLike: Int = 0
)

fun getDefaultCity() = City ( "Москва", 55.755026, 37.617299900000035)


