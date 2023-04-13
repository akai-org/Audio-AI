package pl.org.akai.audioai.screens.login_screen

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import pl.org.akai.audioai.navigation.Screen
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginScreenViewModel = viewModel()
) {
    LaunchedEffect(key1 = viewModel.state) {
        when(viewModel.state.navigate) {
            LoginNavigation.SIGNUP -> {
                navController.navigate(Screen.OnboardingScreen.route)
            }
            LoginNavigation.LOGIN -> {
                navController.navigate(Screen.AssistantScreen.route)
            }
            null -> {}
        }
        viewModel.onAction(LoginScreenAction.NavigationDone)
    }

    // Chyba button Login będzie odpowiadał za navi do AssistantScreena
//    Column(
//        modifier = Modifier
//            .padding(20.dp)
//            .fillMaxHeight(),
//        verticalArrangement = Arrangement.Bottom,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Spacer(modifier = Modifier.height(8.dp))
//        Button(
//            onClick = { navController.navigate(Screen.AssistantScreen.route) },
//            modifier = Modifier.align(Alignment.End)
//        ) {
//            Text(text = "To AssistantScreen")
//        }
//    }

    Column(
        modifier = Modifier
            .padding(50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val context = LocalContext.current
        val uiState = viewModel.state

        Spacer(modifier = Modifier.height(100.dp))
        Text(text = "Login", style = TextStyle(fontSize = 40.sp))

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            label = { Text(text = "Username") },
            value = uiState.userName,
            onValueChange = { viewModel.onAction(LoginScreenAction.TypeUserName(it)) }
        )

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            label = { Text(text = "Password") },
            value = uiState.password,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { viewModel.onAction(LoginScreenAction.TypeUserPassword(it)) }
        )

        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Button(
                onClick = {
                    if(uiState.userName.isEmpty() and uiState.password.isNotEmpty()){
                        Toast.makeText(context, "Username is Empty", Toast.LENGTH_SHORT).show()
                    }
                    if (uiState.userName.isEmpty() and uiState.password.isNotEmpty()){
                        Toast.makeText(context, "Password is Empty", Toast.LENGTH_SHORT).show()
                    }
                    if(uiState.userName.isEmpty() and uiState.password.isNotEmpty()){
                        Toast.makeText(context, "Username and Password are Empty", Toast.LENGTH_SHORT).show()
                    }
                    if(uiState.userName.isNotEmpty() and uiState.password.isNotEmpty()){
                        val user = true //until we have no authorization
                        if (user)
                        {
                            viewModel.onAction(LoginScreenAction.Login)
                            Toast.makeText(context, "You have been logged in.", Toast.LENGTH_SHORT).show()
                        }
                    }
                },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Login")
            }
        }

        //Jeżeli będziemy chcieli ogarniać resetowanie haseł
//        Spacer(modifier = Modifier.height(20.dp))
//        ClickableText(
//            text = AnnotatedString("Forgot password?"),
//            onClick = { },
//            style = TextStyle(
//                fontSize = 14.sp,
//            ),
//            modifier = Modifier.align(Alignment.CenterHorizontally)
//        )


        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "Haven't account yet?", style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold))
        Spacer(modifier = Modifier.height(10.dp))
        ClickableText(
            text = AnnotatedString("Sign up here"),
            onClick = {
                /*Jakiś registerScreen w przyszłości do implementacji pewnie*/
                viewModel.onAction(LoginScreenAction.SignUp)
            },
            style = TextStyle(
                fontSize = 14.sp,
                textDecoration = TextDecoration.Underline,
            )
        )
    }
}









