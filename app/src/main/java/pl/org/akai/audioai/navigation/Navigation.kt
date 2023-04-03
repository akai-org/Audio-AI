package pl.org.akai.audioai.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pl.org.akai.audioai.screens.AssistantScreen
import pl.org.akai.audioai.screens.LoginScreen
import pl.org.akai.audioai.screens.OnboardingScreen
import pl.org.akai.audioai.screens.OptionsScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.OnboardingScreen.route) {
        composable(route = Screen.OnboardingScreen.route) {
            OnboardingScreen(navController = navController)
        }
        composable(route =  Screen.OptionsScreen.route) {
            OptionsScreen(navController = navController)
        }
        composable(route =  Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(route =  Screen.AssistantScreen.route) {
            AssistantScreen()
        }
    }
}