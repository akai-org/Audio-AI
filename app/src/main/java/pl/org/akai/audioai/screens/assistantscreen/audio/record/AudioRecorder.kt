package pl.org.akai.audioai.screens.assistantscreen.audio.record

import java.io.File

interface AudioRecorder {
    fun start(outputFile: File)
    fun stop()
}