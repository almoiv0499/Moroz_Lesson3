package com.example.moroz_lesson3.model

import com.example.moroz_lesson3.R

data class MainScreen(
    val image: Int = R.drawable.title_image,
    val logo: Int = R.drawable.logo,
    val title: String = "",
    val subtitle: String = "",
    val aboutUs: String = "",
    val aboutUsDescription: String = "",
    val viewType: Int = 0
)