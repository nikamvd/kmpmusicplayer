package com.ojinaksha.kmpmusicplayer.android

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.ojinaksha.kmpmusicplayer.Song
import com.ojinaksha.kmpmusicplayer.SongPlayer
import com.ojinaksha.kmpmusicplayer.SongPlayerViewModel

@Composable
fun SongPlayerView(song: Song) {
    val songPlayer = SongPlayer(song)
    val songPlayerViewModel = SongPlayerViewModel(songPlayer)

    var speed by remember { mutableDoubleStateOf(50.0) }
    val gradientColors = listOf(
        Color(0xFFFF4BAA),
        Color(0xFF4D36B9)
    )
    val gradientBrush = Brush.linearGradient(
        colors = gradientColors,
        start = Offset.Zero,
        end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = gradientBrush)
            .padding(10.dp)
    ) {
        // Back Button
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = "Back"
                )
            }
        }
        // Circular image
        Box(
            modifier = Modifier
                .aspectRatio(1f)
                .requiredSize(
                    width = (LocalConfiguration.current.screenHeightDp / 3).dp,
                    height = (LocalConfiguration.current.screenHeightDp / 3).dp
                )
                .clip(CircleShape)
                .border(4.dp, Color.White, CircleShape)
                .shadow(10.dp)
        ) {
            AsyncImage(
                model = song.pictureUrl,
                contentDescription = "Song Poster",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }

        // Movie title
        Text(
            text = song.filmName,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        // Slider and duration labels
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "0:00",
                color = Color.White
            )
            Slider(
                value = speed.toFloat(),
                onValueChange = { speed = it.toDouble() },
                valueRange = 0f..100f,
                colors = SliderDefaults.colors(
                    thumbColor = Color.White,
                    activeTrackColor = Color.Magenta
                ),
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "3:30",
                color = Color.White
            )
        }

        // Song text
        Text(
            text = song.songName,
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        // Control buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Repeat,
                    contentDescription = "Repeat"
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = "Previous"
                )
            }
            Button(
                onClick = { songPlayerViewModel.playSong() },
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Magenta
                ),
                modifier = Modifier.padding(30.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Play/Pause",
                    modifier = Modifier.size(60.dp)
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.ArrowOutward,
                    contentDescription = "Next"
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Shuffle,
                    contentDescription = "Shuffle"
                )
            }
        }
    }
}