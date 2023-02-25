package com.example.moroz_lesson3.model

import com.example.moroz_lesson3.R

data class MainScreen(
    val image: Int = R.drawable.title_image,
    val logo: Int = R.drawable.logo,
    val title: String = DEFAULT_VALUE,
    val subtitle: String = DEFAULT_VALUE,
    val aboutUs: String = DEFAULT_VALUE,
    val aboutUsDescription: String = DEFAULT_VALUE,
    val viewType: Int = 0
) {
    companion object {
        private const val DEFAULT_VALUE = ""
    }
}