package pl.org.akai.audioai.navigation

sealed class Screen(val route: String) {
    object OnboardingScreen : Screen("onboarding_screen")
    object OptionsScreen : Screen("options_screen")
    object LoginScreen : Screen("login_screen")
    object AssistantScreen : Screen("assistant_screen")
}
