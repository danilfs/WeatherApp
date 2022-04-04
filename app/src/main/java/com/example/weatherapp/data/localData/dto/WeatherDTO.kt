package com.example.weatherapp.data.localData.dto

data class WeatherDTO(
    val fact: FactDTO?
)

fun convertDtoToModel(weatherDTO: WeatherDTO): Weather {
    val fact: FactDTO = weatherDTO.fact!!
    return Weather(
        getDefaultCity(), fact.temp!!, fact.feelsLike!!,
        fact.condition!!)

}