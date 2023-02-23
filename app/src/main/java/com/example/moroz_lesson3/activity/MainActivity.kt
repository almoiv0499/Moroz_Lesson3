package com.example.moroz_lesson3.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.moroz_lesson3.R
import com.example.moroz_lesson3.databinding.ActivityMainBinding
import com.example.moroz_lesson3.fragments.authorization.AuthorizationFragment
import com.example.moroz_lesson3.fragments.details.OfficeDetailsFragment
import com.example.moroz_lesson3.fragments.mainscreen.MainScreenFragment
import com.example.moroz_lesson3.fragments.offices.OfficesFragment
import com.example.moroz_lesson3.fragments.util.CustomizeToolbar
import com.example.moroz_lesson3.fragments.util.Navigation
import com.example.moroz_lesson3.fragments.util.NavigationImpl
import com.example.moroz_lesson3.fragments.vacancies.VacanciesFragment
import com.example.moroz_lesson3.model.Office
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val currentFragment: Fragment get() = supportFragmentManager.findFragmentById(R.id.fragment_container)!!
    private val fragmentListener = object : FragmentManager.FragmentLifecycleCallbacks() {
        override fun onFragmentViewCreated(
            fm: FragmentManager,
            f: Fragment,
            v: View,
            savedInstanceState: Bundle?,
        ) {
            super.onFragmentViewCreated(fm, f, v, savedInstanceState)
            updateUI()
        }
    }

    private val navigation get() = NavigationImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        register()
        navigateByBottomNavigation()
    }

    private fun navigateByBottomNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    navigation.navigateToMainScreenInBottomNavigation()
                }
                R.id.vacancies -> {
                    navigation.navigateToVacanciesInBottomNavigation()
                }
                R.id.offices -> {
                    navigation.navigateToOfficesInBottomNavigation()
                }
            }
            true
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregister()
    }

    private fun register() {
        navigation.onCreate(this)
        supportFragmentManager.registerFragmentLifecycleCallbacks(fragmentListener, false)
    }

    private fun unregister() {
        navigation.onDestroy()
        supportFragmentManager.unregisterFragmentLifecycleCallbacks(fragmentListener)
    }

    private fun updateUI() {
        bottomNavigationVisibility()
        customizeToolbar()
    }

    private fun bottomNavigationVisibility() {
        when (currentFragment) {
            is AuthorizationFragment,
            is OfficeDetailsFragment,
            -> binding.bottomNavigation.visibility = View.GONE
            else -> binding.bottomNavigation.visibility = View.VISIBLE
        }
    }

    private fun customizeToolbar() {
        when(val fragment = currentFragment) {
            is CustomizeToolbar -> binding.toolbar.title = getString(fragment.setToolbarTitle())
            else -> binding.toolbar.title = getString(R.string.app_name)
        }
    }
}