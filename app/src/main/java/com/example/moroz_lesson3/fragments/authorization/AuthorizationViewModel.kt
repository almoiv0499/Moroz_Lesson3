package com.example.moroz_lesson3.fragments.authorization

import com.example.moroz_lesson3.fragments.base.BaseViewModel
import com.example.moroz_lesson3.fragments.mainscreen.MainScreenFragment

class AuthorizationViewModel : BaseViewModel() {

    fun navigateToMainScreenFragment() {
        navigateToFragmentWithoutBackStack(MainScreenFragment.newInstance())
    }

}