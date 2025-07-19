package acharya.ajay.ajayacharyaandroid_smartcity_app.api

import acharya.ajay.ajayacharyaandroid_smartcity_app.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {

    @GET("weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric"
    ): WeatherResponse
}