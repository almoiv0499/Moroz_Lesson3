package com.example.moroz_lesson3.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Vacancy(
    val title: String,
    val subtitle: String,
    val image: Int
) : Parcelable
