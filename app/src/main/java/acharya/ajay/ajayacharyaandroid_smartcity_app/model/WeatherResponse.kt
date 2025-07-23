package acharya.ajay.ajayacharyaandroid_smartcity_app.model

data class WeatherResponse(
    val main: Main,
    val weather: List<Weather>
)

data class Main(
    val temp: Double
)

data class Weather(
    val description: String
)