package com.example.moroz_lesson3.fragments.util

import androidx.fragment.app.Fragment

sealed class Navigation {
    data class ToFragmentWithBackStack(val fragment: Fragment) : Navigation()
    data class ToFragmentWithoutBackStack(val fragment: Fragment) : Navigation()
    object ToBack : Navigation()
}