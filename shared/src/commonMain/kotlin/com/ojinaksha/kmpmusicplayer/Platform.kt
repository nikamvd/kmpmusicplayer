package com.ojinaksha.kmpmusicplayer

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform