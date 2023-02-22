package com.example.moroz_lesson3.fragments.offices

import com.example.moroz_lesson3.fragments.base.BaseViewModel
import com.example.moroz_lesson3.fragments.details.OfficeDetailsFragment

class OfficesViewModel : BaseViewModel() {

    fun navigateToOfficeDetails(city: String, address: String) {
        launchFragment(OfficeDetailsFragment.newInstance(city, address))
    }

}