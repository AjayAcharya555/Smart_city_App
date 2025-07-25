﻿# Smart_city_App
 val viewModel: WeatherViewModel = viewModel()
 **
 * Instantiates or retrieves an existing instance of WeatherViewModel
 * scoped to the current composable's lifecycle.
 *
 * This ViewModel holds the state related to the weather data fetched
 * from a remote API using Retrofit. It exposes:
 *  - weatherData: the fetched weather information.
 *  - loading: flag indicating whether a request is in progress.
 *  - error: error message (if any).
 *
 * Jetpack Compose automatically scopes the ViewModel to the current
 * NavBackStackEntry or Activity, which ensures consistent data retention
 * across configuration changes.
 *
 * Example use:
 *   val viewModel: WeatherViewModel = viewModel()
 *   viewModel.loadWeather("London", "your_api_key")

WeatherViewModel.kt
/**
 * ViewModel responsible for fetching and holding weather data
 * using a Retrofit API call.
 *
 * Properties:
 * - weatherData: holds the latest weather response.
 * - loading: true while API call is ongoing.
 * - error: stores error messages to be shown in the UI.
 *
 * Functions:
 * - loadWeather(city: String, apiKey: String)
 *   Launches a coroutine to fetch data asynchronously and update UI state.

 */


  WeatherCard.kt

/**
 * A composable function that displays the weather stats UI block.
 *
 * It uses the ViewModel to observe and display:
 * - Temperature
 * - Weather condition
 * - AQI (hardcoded as "Moderate")
 * - Traffic status (placeholder)
 *
 * It shows a loading spinner during data fetch and an error message if the fetch fails.
 */
@Composable
fun WeatherCard(viewModel: WeatherViewModel = viewModel()) { ... }
