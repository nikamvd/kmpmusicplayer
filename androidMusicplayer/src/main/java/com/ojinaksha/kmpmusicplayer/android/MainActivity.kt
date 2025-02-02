package com.ojinaksha.kmpmusicplayer.android

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ojinaksha.kmpmusicplayer.Song

class MainActivity : ComponentActivity() {

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Lock to portrait mode
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        enableEdgeToEdge(

        )
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val song = Song("Hirve Hirve Gaar Gaaliche",
                        "Phulrani",
                        "https://samusicplayer.blob.core.windows.net/cmusicplayer/Phulrani_HirveHirve.mp3",
                        "https://samusicplayer.blob.core.windows.net/cmusicplayer/Phulrani_Poster.jpg")
                    SongPlayerView(song)
                }
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        val song = Song("Bhimrupi",
            "Ekada Kaay Jhala",
            "https://samusicplayer.blob.core.windows.net/cmusicplayer/Bhimrupi.mp3",
            "https://samusicplayer.blob.core.windows.net/cmusicplayer/EkadaKaayJhala.png")
        SongPlayerView(song)
    }
}
