package com.example.moroz_lesson3.fragments.authorization

import android.os.Handler
import android.os.Looper
import com.example.moroz_lesson3.fragments.base.BaseViewModel
import com.example.moroz_lesson3.fragments.mainscreen.MainScreenFragment

class AuthorizationViewModel : BaseViewModel() {

    fun navigateToMainScreenFragment() {
        Handler(Looper.getMainLooper()).postDelayed({
            launchFragmentWithoutBackStack(MainScreenFragment.newInstance())
        }, 1500)
    }

}