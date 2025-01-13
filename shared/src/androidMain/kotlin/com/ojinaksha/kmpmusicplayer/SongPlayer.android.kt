package com.ojinaksha.kmpmusicplayer

import android.media.MediaPlayer
import android.net.Uri

actual class SongPlayer actual constructor(song: Song) {
    private val mediaPlayer = MediaPlayer()

    init {
        val uri = Uri.parse(song.songUrl)
        mediaPlayer.setDataSource(uri.toString())
        mediaPlayer.prepare()
    }

    actual fun play() {
        mediaPlayer.start()
    }

    actual fun pause() {
        mediaPlayer.pause()
        //mediaPlayer.release()
    }
}