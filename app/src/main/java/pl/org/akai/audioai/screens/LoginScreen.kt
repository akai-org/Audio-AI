package pl.org.akai.audioai.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
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

@Composable
fun LoginScreen(navController: NavController) {
    val context = LocalContext.current
    val sharedPref = context.getSharedPreferences("preferences", Context.MODE_PRIVATE) ?: return
    var checked by remember { mutableStateOf(sharedPref.getBoolean("remember me", false)) }
    var username by remember { mutableStateOf(sharedPref.getString("username", "")!!) }
    var password by remember { mutableStateOf(sharedPref.getString("password", "")!!) }

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
        modifier = Modifier.padding(50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        Text(text = "Login", style = TextStyle(fontSize = 40.sp))
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            label = { Text(text = "Username") },
            value = username,
            onValueChange = { username = it }
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            label = { Text(text = "Password") },
            value = password,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { password = it }
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            Modifier.toggleable(
                value = checked,
                onValueChange = { checked = it },
                role = Role.Checkbox
            )
        ) {
            Checkbox(checked = checked, onCheckedChange = null)
            Text("remember me")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Button(
                onClick = {
                    if (username.isEmpty() and password.isNotEmpty()) {
                        Toast.makeText(context, "Username is Empty", Toast.LENGTH_SHORT).show()
                    }
                    if (username.isEmpty() and password.isNotEmpty()) {
                        Toast.makeText(context, "Password is Empty", Toast.LENGTH_SHORT).show()
                    }
                    if (username.isEmpty() and password.isEmpty()) {
                        Toast.makeText(
                            context, "Username and Password are Empty", Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (username.isNotEmpty() and password.isNotEmpty()) {
                        val user = true //until we have no authorization
                        if (user) {
                            with(sharedPref.edit()) {
                                putBoolean("remember me", checked)
                                putString("username", if (checked) username else "")
                                putString("password", if (checked) password else "")
                                apply()
                            }
                            navController.navigate(Screen.AssistantScreen.route)
                            Toast.makeText(
                                context,
                                "You have been logged in.",
                                Toast.LENGTH_SHORT
                            ).show()
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
        Text(
            text = "Haven't account yet?",
            style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold)
        )
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









