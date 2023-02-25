package com.example.moroz_lesson3.activity

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.moroz_lesson3.R
import com.example.moroz_lesson3.databinding.ActivityMainBinding
import com.example.moroz_lesson3.fragments.authorization.AuthorizationFragment
import com.example.moroz_lesson3.fragments.details.OfficeDetailsFragment
import com.example.moroz_lesson3.fragments.util.CustomizeOfficeToolbar
import com.example.moroz_lesson3.fragments.util.CustomizeToolbar
import com.example.moroz_lesson3.fragments.util.NavigationImpl

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val currentFragment: Fragment
        get() = supportFragmentManager.findFragmentById(R.id.fragment_container)!!

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
        setSupportActionBar(binding.toolbar)

        register()
        navigateByBottomNavigation()
        handleBackPressed()
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
        val fragment = currentFragment
        setBottomNavigationVisibility(fragment)
        customizeOfficeToolbar(fragment)
        customizeToolbar(fragment)
    }

    private fun setBottomNavigationVisibility(fragment: Fragment) {
        when (fragment) {
            is AuthorizationFragment,
            is OfficeDetailsFragment,
            -> binding.bottomNavigation.visibility = View.GONE
            else -> binding.bottomNavigation.visibility = View.VISIBLE
        }
    }

    private fun customizeToolbar(fragment: Fragment) {
        when (fragment) {
            is CustomizeToolbar -> binding.toolbar.title = getString(fragment.setToolbarTitle())
            is CustomizeOfficeToolbar -> binding.toolbar.title =
                getString(fragment.setToolbarTitle())
            else -> binding.toolbar.title = getString(R.string.app_name)
        }
    }

    private fun customizeOfficeToolbar(fragment: Fragment) {
        when (fragment) {
            is CustomizeOfficeToolbar -> {
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
                supportActionBar?.setDisplayShowHomeEnabled(true)
                binding.toolbar.setNavigationOnClickListener {
                    navigation.navigateBack()
                }
            }
            else -> {
                supportActionBar?.setDisplayHomeAsUpEnabled(false)
                supportActionBar?.setDisplayShowHomeEnabled(false)
            }
        }
    }

    private fun handleBackPressed() {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                when {
                    isMainScreen() -> finish()
                    isOfficeDetailsFragment() -> navigation.navigateBack()
                    else -> binding.bottomNavigation.selectedItemId = R.id.home
                }
            }
        }
        onBackPressedDispatcher.addCallback(this, callback)
    }

    private fun isMainScreen(): Boolean {
        return binding.bottomNavigation.selectedItemId == R.id.home
    }

    private fun isOfficeDetailsFragment() = currentFragment is OfficeDetailsFragment

}