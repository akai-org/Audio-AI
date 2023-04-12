package pl.org.akai.audioai.screens

import android.graphics.fonts.FontFamily
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import pl.org.akai.audioai.navigation.Screen

@Composable
fun LoginScreen(navController: NavController) {

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
        val username = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }

        Spacer(modifier = Modifier.height(100.dp))
        Text(text = "Login", style = TextStyle(fontSize = 40.sp))

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            label = { Text(text = "Username") },
            value = username.value,
            onValueChange = { username.value = it })

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            label = { Text(text = "Password") },
            value = password.value,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { password.value = it })

        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Button(
                onClick = {
                    if(username.value.isEmpty() and password.value.isNotEmpty()){
                        Toast.makeText(context, "Username is Empty", Toast.LENGTH_SHORT).show()
                    }
                    if (username.value.isEmpty() and password.value.isNotEmpty()){
                        Toast.makeText(context, "Password is Empty", Toast.LENGTH_SHORT).show()
                    }
                    if(username.value.isEmpty() and password.value.isEmpty()){
                        Toast.makeText(context, "Username and Password are Empty", Toast.LENGTH_SHORT).show()
                    }
                    if(username.value.isNotEmpty() and password.value.isNotEmpty()){
                        val user = true //until we have no authorization
                        if (user)
                        {
                            navController.navigate(Screen.AssistantScreen.route)
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
                navController.navigate(Screen.OnboardingScreen.route)
                      },
            style = TextStyle(
                fontSize = 14.sp,
                textDecoration = TextDecoration.Underline,
            )
        )
    }
}









