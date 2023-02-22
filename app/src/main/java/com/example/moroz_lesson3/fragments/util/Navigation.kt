package com.example.moroz_lesson3.fragments.util

import androidx.fragment.app.Fragment

sealed class Navigation {
    data class ToFragment(val fragment: Fragment) : Navigation()
    object ToBack : Navigation()
}