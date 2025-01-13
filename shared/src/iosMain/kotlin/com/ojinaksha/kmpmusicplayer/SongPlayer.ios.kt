package com.ojinaksha.kmpmusicplayer

import platform.AVFoundation.*
import platform.Foundation.NSURL

actual class SongPlayer actual constructor(song: Song) {
    private val player: AVPlayer

    init {
        val url = NSURL.URLWithString(song.songUrl) ?: throw IllegalArgumentException("Invalid URL: $song.songUrl")
        val playerItem = AVPlayerItem(url)
        player = AVPlayer(playerItem)
    }

    actual fun play() {
        player.play()
    }

    actual fun pause() {
        player.pause()
    }
}