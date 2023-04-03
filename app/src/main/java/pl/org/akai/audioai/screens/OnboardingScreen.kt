package pl.org.akai.audioai.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import pl.org.akai.audioai.navigation.Screen


@Composable
fun OnboardingScreen(navController: NavController) {
    Column (verticalArrangement = Arrangement.Center) {
        Text("OnboardingScreen")
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            navController.navigate(Screen.OptionsScreen.route)
        },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "To OptionsScreen")
        }
    }
}

