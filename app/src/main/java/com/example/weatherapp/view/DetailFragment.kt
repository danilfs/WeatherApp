package com.example.weatherapp.view

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.weatherapp.R
import com.example.weatherapp.data.Weather
import com.example.weatherapp.data.WeatherLoader
import com.example.weatherapp.databinding.FragmentDetailBinding


class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var weatherBundle: Weather

    private val loadListener  =
        object : WeatherLoader.WeatherLoaderListener {
            override fun onLoaded(weatherDTO: WeatherDTO) {
                displayWeather(weatherDTO)
            }

            override fun onFailed(throwable: Throwable) {
                TODO("Not yet implemented")
            }

        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<Weather>(BUNDLE_EXTRA)?.let { weather ->
            weatherBundle = weather
        }
        binding.mainView.visibility = View.GONE
        binding.loadingLayout.visibility = View.VISIBLE
        loadWeather()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun loadWeather() {
        val weatherLoader = WeatherLoader(loadListener, weatherBundle.city.lat, weatherBundle.city.lon)
        weatherLoader.loadWeather()
    }

    private fun displayWeather(weatherDTO: WeatherDTO) {
        with(binding) {
            mainView.visibility = View.VISIBLE
            loadingLayout.visibility = View.GONE
            val city = weatherBundle.city
            cityName.text = city.city
            cityCoordinates.text = String.format(
                getString(R.string.city_coordinates),
                city.lat.toString(),
                city.lon.toString()
            )
            weatherCondition.text = weatherDTO.fact?.condition
            temperatureValue.text = weatherDTO.fact?.temp.toString()
            feelsLikeValue.text = weatherDTO.fact?.feelsLike.toString()
        }
    }



    companion object {

        const val BUNDLE_EXTRA = "weather"
    }
}
