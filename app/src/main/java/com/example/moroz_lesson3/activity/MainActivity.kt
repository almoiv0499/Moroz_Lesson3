package com.example.moroz_lesson3.activity

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.moroz_lesson3.R
import com.example.moroz_lesson3.databinding.ActivityMainBinding
import com.example.moroz_lesson3.fragments.authorization.AuthorizationFragment
import com.example.moroz_lesson3.fragments.details.OfficeDetailsFragment
import com.example.moroz_lesson3.fragments.mainscreen.MainScreenFragment
import com.example.moroz_lesson3.fragments.offices.OfficesFragment
import com.example.moroz_lesson3.fragments.vacancies.VacanciesFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigateByBottomNavigation()
    }

    private fun navigateByBottomNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
            val fragmentManager = supportFragmentManager
            when (menuItem.itemId) {
                R.id.home -> {
                    val fragment = MainScreenFragment.newInstance()
                    viewModel.navigationBetweenFragments(fragmentManager, fragment)
                }
                R.id.vacancies -> {
                    val fragment = VacanciesFragment.newInstance()
                    viewModel.navigationBetweenFragments(fragmentManager, fragment)
                }
                R.id.offices -> {
                    val fragment = OfficesFragment.newInstance()
                    viewModel.navigationBetweenFragments(fragmentManager, fragment)
                }
                else -> {
                    binding.bottomNavigation.visibility = View.GONE
                }
            }
            true
        }
    }

    fun checkFragment(fragment: Fragment) {
        when (fragment) {
            is AuthorizationFragment,
            is OfficeDetailsFragment,
            -> binding.bottomNavigation.visibility = View.GONE
            else -> binding.bottomNavigation.visibility = View.VISIBLE
        }
    }
}