package com.example.weatherapp.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class City(
    var city: String?,
    val lat: Double,
    val lon: Double

) : Parcelable