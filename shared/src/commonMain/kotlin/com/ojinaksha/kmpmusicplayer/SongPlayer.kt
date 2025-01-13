package com.ojinaksha.kmpmusicplayer

expect class SongPlayer(song: Song) {
    fun play()
    fun pause()
}