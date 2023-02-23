package com.example.moroz_lesson3.fragments.util

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.example.moroz_lesson3.R
import com.example.moroz_lesson3.activity.MainActivity
import com.example.moroz_lesson3.fragments.authorization.AuthorizationFragment
import com.example.moroz_lesson3.fragments.details.OfficeDetailsFragment
import com.example.moroz_lesson3.fragments.mainscreen.MainScreenFragment
import com.example.moroz_lesson3.fragments.offices.OfficesFragment
import com.example.moroz_lesson3.fragments.vacancies.VacanciesFragment
import com.example.moroz_lesson3.model.Office
import com.google.android.material.bottomnavigation.BottomNavigationView

object NavigationImpl : Navigation {

    private var activity: MainActivity? = null

    fun onCreate(mainActivity: MainActivity) {
        activity = mainActivity
    }

    override fun navigateFromAuthorizationToMainScreen() {
        launchModeFromAuthorization()
    }

    override fun navigateToMainScreenInBottomNavigation() {
        val fragment = MainScreenFragment.newInstance()
        launchModeWithPopBackStack(fragment)
    }

    override fun navigateToVacanciesInBottomNavigation() {
        val fragment = VacanciesFragment.newInstance()
        launchModeWithPopBackStack(fragment)
    }

    override fun navigateToOfficesInBottomNavigation() {
        val fragment = OfficesFragment.newInstance()
        launchModeWithPopBackStack(fragment)
    }

    override fun navigateToOfficesDetails(office: Office) {
        launchModeToOfficeDetails(office)
    }

    override fun navigateBack() {
        backPressed()
    }

    override fun bottomNavigationVisibility(fragment: Fragment) {
        when (fragment) {
            is AuthorizationFragment,
            is OfficeDetailsFragment,
            -> activity?.findViewById<BottomNavigationView>(R.id.bottom_navigation)?.visibility =
                View.GONE
            else -> activity?.findViewById<BottomNavigationView>(R.id.bottom_navigation)?.visibility =
                View.VISIBLE
        }
    }

    fun onDestroy() {
        activity = null
    }

    private fun launchModeWithPopBackStack(fragment: Fragment) {
        activity?.let { activity ->
            activity.supportFragmentManager.popBackStack(
                null, FragmentManager.POP_BACK_STACK_INCLUSIVE
            )
            activity.supportFragmentManager.commit {
                replace(R.id.fragment_container, fragment)
                addToBackStack(null)
            }
        }
    }

    private fun launchModeFromAuthorization() {
        val fragment = MainScreenFragment.newInstance()
        activity?.supportFragmentManager?.commit {
            replace(R.id.fragment_container, fragment)
        }
    }

    private fun launchModeToOfficeDetails(office: Office) {
        val fragment = OfficeDetailsFragment.newInstance(office)
        activity?.supportFragmentManager?.commit {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
        }
    }

    private fun backPressed() {
        activity?.supportFragmentManager?.popBackStack()
    }
}