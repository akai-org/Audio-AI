package pl.org.akai.audioai.screens.login_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginScreenViewModel : ViewModel() {

    var state by mutableStateOf(LoginScreenState())
        private set

    fun onAction(action: LoginScreenAction) {
        state = when(action) {
            LoginScreenAction.Login -> {
                state.copy(navigate = LoginNavigation.LOGIN)
            }
            LoginScreenAction.SignUp -> {
                state.copy(navigate = LoginNavigation.SIGNUP)
            }
            is LoginScreenAction.TypeUserName -> {
                state.copy(userName = action.username)
            }
            is LoginScreenAction.TypeUserPassword -> {
                state.copy(password = action.password)
            }
            is LoginScreenAction.ChangeRememberMe -> {
                state.copy(rememberMeChecked = action.rememberMe)
            }
            LoginScreenAction.NavigationDone -> {
                state.copy(navigate = null)
            }
        }
    }
}