package com.ojinaksha.kmpmusicplayer.android

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ojinaksha.kmpmusicplayer.Song
import com.ojinaksha.kmpmusicplayer.SongPlayer
import com.ojinaksha.kmpmusicplayer.SongPlayerViewModel

@Composable
fun SongScreen(song: Song) {
    val songPlayer = SongPlayer(song)
    val songPlayerViewModel = SongPlayerViewModel(songPlayer)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "My Song App", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { songPlayerViewModel.playSong() },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Play Song")
        }
        Spacer(modifier = Modifier.height(15.dp))
        Button(
            onClick = { songPlayerViewModel.stopSong() },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Pause Song")
        }
    }
}