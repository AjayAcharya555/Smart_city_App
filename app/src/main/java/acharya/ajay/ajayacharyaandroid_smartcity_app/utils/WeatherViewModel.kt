package acharya.ajay.ajayacharyaandroid_smartcity_app.utils

import acharya.ajay.ajayacharyaandroid_smartcity_app.api.RetrofitClient
import acharya.ajay.ajayacharyaandroid_smartcity_app.model.WeatherResponse
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    var weatherState by mutableStateOf<WeatherResponse?>(null)
        private set

    init {
        getWeather()
    }

    private fun getWeather() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.api.getWeather(
                    city = "Bangalore",
                    apiKey = "d9d5a91176c696462990ee0e31100769" // Replace with your OpenWeatherMap API key
                )
                weatherState = response
            } catch (e: Exception) {
                Log.e("WeatherError", e.toString())
            }
        }
    }
}