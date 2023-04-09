package pl.org.akai.audioai.screens

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import pl.org.akai.audioai.navigation.Screen

@Composable
fun LoginScreen(navController: NavController) {
    val context = LocalContext.current
    val sharedPref = context.getSharedPreferences("preferences", Context.MODE_PRIVATE) ?: return
    val rememberMe = sharedPref.getBoolean("remember_me", false)
    val (checked, setChecked) = remember { mutableStateOf(rememberMe) }
    LaunchedEffect(Unit) {
        if (rememberMe) {
            navController.navigate(Screen.AssistantScreen.route)
        }
    }

    Column(verticalArrangement = Arrangement.Center) {
        Text("LoginScreen")
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                with(sharedPref.edit()) {
                    putBoolean("remember_me", checked)
                    apply()
                }
                navController.navigate(Screen.AssistantScreen.route)
            }, modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "To AssistantScreen")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            Modifier.toggleable(
                value = checked,
                onValueChange = { setChecked(!checked) },
                role = Role.Checkbox,
            ),
        ) {
            Checkbox(checked = checked, onCheckedChange = null)
            Text("remember me")
        }
    }
}