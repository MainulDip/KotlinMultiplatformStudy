package com.example.intro_001_kmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform