package pl.org.akai.audioai.screens.login_screen

data class LoginScreenState(
    val userName: String = "",
    val password: String = "",
    val rememberMeChecked: Boolean = false,
    val navigate: LoginNavigation? = null
)

enum class LoginNavigation{
    SIGNUP, LOGIN
}
