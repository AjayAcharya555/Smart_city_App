package acharya.ajay.ajayacharyaandroid_smartcity_app

import acharya.ajay.ajayacharyaandroid_smartcity_app.utils.Screen
import acharya.ajay.ajayacharyaandroid_smartcity_app.utils.WeatherViewModel
import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.unit.sp

@Composable
fun SmartCityHubScreen(viewModel: WeatherViewModel, navController: NavController?) {
    val weather = viewModel.weatherState

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())


    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text("Smart City Hub", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Icon(Icons.Default.Settings, contentDescription = "Settings")
        }


        Spacer(modifier = Modifier.height(26.dp))
// Quick Stats Section
        Text("Quick Stats", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            QuickStatCard(icon = Icons.Default.Star, title = "${weather?.main?.temp ?: "--"}°C", subtitle = (weather?.weather?.firstOrNull()?: "Loading").toString())
            QuickStatCard(icon = Icons.Default.LocationOn, title = "AQI", subtitle = "Moderate")
            QuickStatCard(icon = Icons.Default.Info, title = "Traffic", subtitle = "Normal")
        }

        Spacer(modifier = Modifier.height(28.dp))

        // Services Grid
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            content = {
                item {
                    ServiceCard(icon = Icons.Default.Favorite, title = "Public Transport",
                        onClick = { navController?.navigate(Screen.PublicTransport.route) })
                }
                item {
                    ServiceCard(
                        icon = Icons.Default.Add,
                        title = "Emergency Services",
                        onClick = { navController?.navigate(Screen.Emergency.route) }
                    )
                }
                item {
                    ServiceCard(
                        icon = Icons.Default.Delete,
                        title = "Waste Mgmt."
                    ) { navController?.navigate(Screen.PublicTransport.route) }
                }
                item {
                    ServiceCard(
                        icon = Icons.Default.DateRange,
                        title = "City Events"
                    ) { navController?.navigate(Screen.PublicTransport.route) }
                }
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Alerts Section
        Text("City Alerts", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
        AlertItem(title = "Road Closure", description = "Main St. closed this week")
        AlertItem(title = "Severe Weather", description = "Thunderstorms expected")
        AlertItem(title = "Power Outage", description = "Downtown, check updates")
    }
}

@Composable
fun QuickStatCard(icon: ImageVector, title: String, subtitle: String) {
    Card(
        modifier = Modifier

            .padding(horizontal = 4.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(icon, contentDescription = null, tint = Color.Black)
            Text(title, fontWeight = FontWeight.Bold, )
            if (subtitle.isNotEmpty()) {
                Text(subtitle, fontSize = 12.sp, color = Color.Gray, overflow = TextOverflow.Ellipsis, maxLines = 1)
            }
        }
    }
}

@Composable
fun ServiceCard(icon: ImageVector, title: String, onClick: () -> Unit?) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(12.dp)
                .clickable { onClick() }
                .fillMaxWidth()
        ) {
            Icon(icon, contentDescription = title, tint = Color.Black)
            Spacer(modifier = Modifier.width(8.dp))
            Text(title, fontWeight = FontWeight.Medium)
        }
    }
}

@Composable
fun AlertItem(title: String, description: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(title, fontWeight = FontWeight.Bold)
        Text(description, fontSize = 12.sp, color = Color.Gray)
        Divider(modifier = Modifier.padding(top = 4.dp))
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Composable
@Preview(showBackground = true)
fun SmartCityHubScreenPreview() {
    val navController = null
    SmartCityHubScreen(viewModel = WeatherViewModel(), navController = navController)
}