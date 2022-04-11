package com.example.weatherapp.presentation.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.data.details.DetailsRepository
import com.example.weatherapp.data.details.IDetailsRepository
import com.example.weatherapp.data.details.RemoteDataSource
import com.example.weatherapp.data.localData.dto.WeatherDTO
import com.example.weatherapp.data.localData.dto.convertDtoToModel
import com.example.weatherapp.data.states.AppState
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val SERVER_ERROR = "Ошибка сервера"
private const val REQUEST_ERROR = "Ошибка запроса на сервер"
private const val CORRUPTED_DATA = "Неполные данные"

class DetailsViewModel(
    private val detailsLiveData: MutableLiveData<AppState> = MutableLiveData(),
    private val detailsRepository: IDetailsRepository =
        DetailsRepository(RemoteDataSource())
) : ViewModel() {
    val liveData: LiveData<AppState> get() = detailsLiveData

    fun getWeatherFromRemoteSource(lat: Double, lon: Double) {
        detailsLiveData.postValue(AppState.Loading)
        detailsRepository.getWeatherDetailsFromServer(lat, lon, callBack)
    }

    private val callBack = object : Callback<WeatherDTO>{
        override fun onResponse(call: Call<WeatherDTO>, response: Response<WeatherDTO>) {
            val serverResponse: WeatherDTO? = response.body()
            detailsLiveData.postValue(
                if (response.isSuccessful && serverResponse != null) {
                    checkResponse(serverResponse)
                } else {
                    AppState.Error(Throwable(SERVER_ERROR))
                }
            )

        }

        override fun onFailure(call: Call<WeatherDTO>, t: Throwable) {
            detailsLiveData.postValue(
                AppState.Error(Throwable(t.message ?:
            REQUEST_ERROR)))

        }

        private fun checkResponse(serverResponse: WeatherDTO): AppState {
            val fact = serverResponse.fact
            return if (fact?.temp == null || fact.feelsLike ==
                null || fact.condition.isNullOrEmpty()) {
                AppState.Error(Throwable(CORRUPTED_DATA))
            } else {
                AppState.SuccessDetails(convertDtoToModel(serverResponse))
            }
        }


    }
}