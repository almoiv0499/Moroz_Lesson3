package com.example.moroz_lesson3.activity

import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModel
import com.example.moroz_lesson3.R

class MainActivityViewModel : ViewModel() {

    fun navigationBetweenFragments(activity: MainActivity, fragment: Fragment) {
        activity.supportFragmentManager.commit {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
        }
    }

}