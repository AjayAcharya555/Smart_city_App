package acharya.ajay.ajayacharyaandroid_smartcity_app
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EmergencyScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Emergency Services", fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(10.dp))
        Text("Show hospitals, police, fire department, etc.")
    }
}