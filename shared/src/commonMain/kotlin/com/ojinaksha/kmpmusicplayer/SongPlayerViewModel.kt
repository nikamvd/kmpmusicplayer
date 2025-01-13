package com.ojinaksha.kmpmusicplayer

class SongPlayerViewModel(private val songPlayer : SongPlayer) {

    fun playSong() {
        songPlayer.play()
    }

    fun stopSong() {
        songPlayer.pause()
    }
}