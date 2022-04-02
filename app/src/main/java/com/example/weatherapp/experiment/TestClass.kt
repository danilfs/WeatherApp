package com.example.weatherapp.experiment

import com.example.weatherapp.data.City
import com.example.weatherapp.data.Weather
import java.net.HttpURLConnection
import java.net.URL
import java.util.*
import javax.net.ssl.HttpsURLConnection

class TestClass {

    fun job(): Unit {
        var notNullable: String = ""

        var nullable: String? = ""
        //nullable = null

        //nullable = notNullable

        if (nullable != null) {
            val len = nullable.length
            notNullable = nullable
        }
        val lenSafe = nullable?.length

        val w: Weather?
        w = Weather()
        val lenCity: Int = w?.city?.city?.length ?: 0
        val lenNotNull: Int = nullable!!.length
        notNullable = nullable!!
        TestJavaClass.i?.length
        val any = Any()

        var array: Array<String> = arrayOf("fsdgsd", "sdgsd", "sfdsf")
        array[2] = "fsdfergs"
        val value = array[0]
        array.size

        val list: List<String> = mutableListOf("ds", "sdfsdfrg", "sdfdsfsdf", "", "")
        val resultList = list.filter { element -> element.length > 3 }

        val intList = list.map { it.length }
        val strList = intList.map { intToStr(it) }
        val filteredIntList =
            list.filter { element -> element.length > 3 }
                .map { it.length }
                .filter { it > 4 }
                .sortedBy { it }

        val findVal = list.find { it == "sdfsdfrg" }
        val count = list.count { it == ""}
        val ktStr = "${w.feelsLike} oshushenie ${w.temperature}fdsgfsg ${count}"
        val str = w.feelsLike.toString() + " oshushenie" + w.temperature.toString() + "fdsgfsg"
        val viewState : BaseViewState<Any, Int> = BaseViewState<String, Int>()
        val obj : Any = viewState.doIt()
    }

    private fun star(l: List<*>){

    }

    private fun intToStr(i: Int): String =
        when (i) {
            0 -> "nol"
            1 -> "odin"
            else -> "mnogo"
        }

    fun main(args: Array<String>) {
        print(greetingFun)
    }

    val greetingFun = fun(): String {
        var result = "Hello?"
        result = result.replace("?", "")
        return result
    }

    val greetingFunShort = { "Hello"}

    val sum = { a: Int, b: Int ->
        a + b
    }

    fun print(block: () -> String) {
        println(block())
    }

    fun less4(){
        val city = City("Msk", 24.4545, 78.545)
        val cityNullable: City? = City()
        val latlon = city.getLatLon()
        val reverce = latlon.reversed()

        with(city) {
            this.city = "new"
            lat = 24.545
            lon = 45.5454

        }

        val applayCity = City().apply {
            lat = 54.5454
            lon = 547.5454
            this.city = "dfhdghdgh"
        }

        cityNullable?.let {
            it.doSomething()
        }

        val cityAlso = city.also {
            print(it.city)
        }

        val len = cityNullable?.city?.length ?: 0
        val lenq = cityNullable!!.city!!.length

        city.city = "New-York"
        city.lat = 21.45454
        city.lon = 45.5445
    }

    fun getDefaultLocale(deliveryArea: String): Locale {
        val deliverAreaLower = deliveryArea.toLowerCase()
        if (deliverAreaLower == "germany" || deliverAreaLower == "austria") {
            return Locale.GERMAN
        }
        if (deliverAreaLower == "usa" || deliverAreaLower == "great britain") {
            return Locale.ENGLISH
        }
        if (deliverAreaLower == "france") {
            return Locale.FRENCH
        }
        return Locale.ENGLISH
    }

    fun getDefaultLocaleK(deliveryArea: String) = when (deliveryArea.toLowerCase()) {
        "germany", "austria" -> Locale.GERMAN
        "usa", "great britain" -> Locale.ENGLISH
        "france" -> Locale.FRENCH
        else -> Locale.ENGLISH
    }

    fun inet(){
        var urlConnection: HttpURLConnection? = null
        var urlConnectionS: HttpsURLConnection? = null
        val url = URL("yandex.ru") // Указать адрес URI
        urlConnection = url.openConnection() as HttpURLConnection
        urlConnection.requestMethod = "GET"
        urlConnection.readTimeout = 10000 //10sek
        urlConnection.disconnect()
    }

}