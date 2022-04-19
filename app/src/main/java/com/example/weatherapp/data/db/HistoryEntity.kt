package com.example.weatherapp.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

const val ID = "id"
const val CITY = "city"
const val TEMPERATURE = "temperature"

@Entity
data class HistoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = -1,
    val city: String = "",
    val temperature: Int = -1,
    val condition: String = ""
)
