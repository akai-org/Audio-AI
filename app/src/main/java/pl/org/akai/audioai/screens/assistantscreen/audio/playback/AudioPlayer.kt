package pl.org.akai.audioai.screens.assistantscreen.audio.playback

import java.io.File

interface AudioPlayer {
    fun playFile(file: File)
    fun stop()
}