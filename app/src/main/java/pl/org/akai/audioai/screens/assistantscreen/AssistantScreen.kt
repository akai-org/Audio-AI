package pl.org.akai.audioai.screens

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import pl.org.akai.audioai.screens.assistantscreen.audio.playback.AndroidAudioPlayer
import pl.org.akai.audioai.screens.assistantscreen.audio.record.AndroidAudioRecorder
import java.io.File


@Composable
fun AssistantScreen() {

    val context = LocalContext.current

    val recorder by lazy {
        AndroidAudioRecorder(context)
    }

    val player by lazy {
        AndroidAudioPlayer(context)
    }

    var audioFile: File? = null

    Column (modifier = Modifier. fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            File(context.cacheDir, "audio.mp3").also {
                recorder.start(it)
                audioFile = it
            }
        }) {
            Text(text = "RECORD")
        }
        Button(onClick = {
            recorder.stop()
        }) {
            Text(text = "STOP RECORD")
        }
        Button(onClick = {
            player.playFile(audioFile ?: return@Button)
        }) {
            Text(text = "PLAY")
        }
        Button(onClick = {
            player.stop()
        }) {
            Text(text = "STOP PLAY")
        }
    }
}