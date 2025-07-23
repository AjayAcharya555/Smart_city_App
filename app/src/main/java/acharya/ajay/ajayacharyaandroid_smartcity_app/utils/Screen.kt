package acharya.ajay.ajayacharyaandroid_smartcity_app.utils

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object PublicTransport : Screen("public_transport")
    object Emergency : Screen("emergency")
}