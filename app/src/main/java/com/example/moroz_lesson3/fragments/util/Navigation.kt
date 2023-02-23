package com.example.moroz_lesson3.fragments.util

import androidx.fragment.app.Fragment
import com.example.moroz_lesson3.model.Office

interface Navigator {

    fun navigateFromAuthorizationToMainScreen()

    fun navigateToMainScreenInBottomNavigation(fragment: Fragment)

    fun navigateToVacanciesInBottomNavigation(fragment: Fragment)

    fun navigateToOfficesInBottomNavigation(fragment: Fragment)

    fun navigateToOfficesDetails(office: Office)

    fun navigateBack()

    fun bottomNavigationVisibility(fragment: Fragment)
}

fun Fragment.navigation(): Navigator = requireActivity() as Navigator