package com.example.weatherapp.experiment

data class City(
    var city: String? = "",
    var lat: Double = 0.0,
    var lon: Double = 0.0
){
    fun doSomething(){

    }
}
//24.4545, 78.545
//24.4545 / 78.545
fun City.getLatLon() = "${this.lat} / ${this.lon}"