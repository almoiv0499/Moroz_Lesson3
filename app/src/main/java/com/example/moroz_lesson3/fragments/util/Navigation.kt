package com.example.moroz_lesson3.fragments.util

import androidx.fragment.app.Fragment

sealed class Navigation {
    data class ToFragment(val fragment: Fragment) : Navigation()
    data class ToFragmentWithoutBackStack(val fragmentWithoutBackStack: Fragment) : Navigation()
    object ToBack : Navigation()
}