package com.example.weatherapp.data.details

import com.example.weatherapp.data.localData.dto.WeatherDTO
import retrofit2.Callback

class DetailsRepository(private val remoteDataSource: RemoteDataSource) : IDetailsRepository {
    override fun getWeatherDetailsFromServer(lat: Double, lon: Double, callback: Callback<WeatherDTO>) {
        remoteDataSource.getWeatherDetails(lat, lon, callback)
    }
}