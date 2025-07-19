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

    var weatherData by mutableStateOf<WeatherResponse?>(null)
    var loading by mutableStateOf(false)
    var error by mutableStateOf("")

    fun loadWeather(city: String, apiKey: String) {
        viewModelScope.launch {
            loading = true
            error = ""
            try {
                weatherData = RetrofitClient.api.getWeather(city, apiKey)
            } catch (e: Exception) {
                error = "Failed to load weather"
            } finally {
                loading = false
            }
        }
    }
}