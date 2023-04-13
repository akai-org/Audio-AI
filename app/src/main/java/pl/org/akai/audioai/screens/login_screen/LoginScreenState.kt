package pl.org.akai.audioai.screens.login_screen

data class LoginScreenState(
    val userName: String = "",
    val password: String = "",
    val navigate: LoginNavigation? = null
)

enum class LoginNavigation{
    SIGNUP, LOGIN
}
