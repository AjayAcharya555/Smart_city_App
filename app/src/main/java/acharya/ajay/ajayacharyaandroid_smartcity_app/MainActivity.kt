package acharya.ajay.ajayacharyaandroid_smartcity_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import acharya.ajay.ajayacharyaandroid_smartcity_app.ui.theme.AjayAcharyaAndroid_SmartCity_AppTheme
import acharya.ajay.ajayacharyaandroid_smartcity_app.utils.Screen
import acharya.ajay.ajayacharyaandroid_smartcity_app.utils.WeatherViewModel
import android.annotation.SuppressLint
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {


    @SuppressLint("ViewModelConstructorInComposable")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //val weatherViewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)

        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()


                AjayAcharyaAndroid_SmartCity_AppTheme {

                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {

                        NavHost(navController = navController, startDestination = Screen.Home.route) {
                            composable(Screen.Home.route) {
                                SmartCityHubScreen( viewModel = WeatherViewModel(), navController = navController)
                            }
                            composable(Screen.PublicTransport.route) {
                                PublicTransportScreen()
                            }
                            composable(Screen.Emergency.route) {
                                EmergencyScreen()
                            }
                    }

                }
            }
        }
    }

}
@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@Composable
fun GreetingPreview(navController: NavController?) {
    AjayAcharyaAndroid_SmartCity_AppTheme {
        SmartCityHubScreen(
            viewModel = WeatherViewModel(),
            navController = navController
        )
    }
}
