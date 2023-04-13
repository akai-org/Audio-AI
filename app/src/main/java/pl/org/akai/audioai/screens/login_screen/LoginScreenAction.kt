package pl.org.akai.audioai.screens.login_screen

sealed class LoginScreenAction{
    class TypeUserName(val username: String): LoginScreenAction()
    class TypeUserPassword(val password: String): LoginScreenAction()
    object Login: LoginScreenAction()
    object SignUp: LoginScreenAction()
    object NavigationDone: LoginScreenAction()
}
