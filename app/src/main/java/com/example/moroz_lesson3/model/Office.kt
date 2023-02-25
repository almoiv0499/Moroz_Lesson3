package com.example.moroz_lesson3.model

import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Office(
    val city: String,
    val address: String,
    val phoneNumber: String,
    val viewType: Int = 0
) : Parcelable

inline fun <reified T : Parcelable> Bundle.parcelable(key: String): T? = when {
    SDK_INT >= 33 -> getParcelable(key, T::class.java)
    else -> @Suppress("DEPRECATION") getParcelable(key) as? T
}
