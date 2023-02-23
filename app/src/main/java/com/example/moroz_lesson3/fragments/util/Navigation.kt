package com.example.moroz_lesson3.fragments.util

import androidx.fragment.app.Fragment
import com.example.moroz_lesson3.model.Office

interface Navigation {

    fun navigateFromAuthorizationToMainScreen()

    fun navigateToMainScreenInBottomNavigation()

    fun navigateToVacanciesInBottomNavigation()

    fun navigateToOfficesInBottomNavigation()

    fun navigateToOfficesDetails(office: Office)

    fun navigateBack()
}

fun Fragment.navigation(): Navigation = NavigationImpl