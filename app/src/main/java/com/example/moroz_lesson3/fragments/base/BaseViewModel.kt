package com.example.moroz_lesson3.fragments.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moroz_lesson3.fragments.util.Event
import com.example.moroz_lesson3.fragments.util.Navigation

abstract class BaseViewModel : ViewModel() {

    private val _liveDataNavigation = MutableLiveData<Event<Navigation>>()
    val liveDataNavigation: LiveData<Event<Navigation>> = _liveDataNavigation

    fun navigateToFragmentWithBackStack(fragment: Fragment) {
        _liveDataNavigation.value = Event(Navigation.ToFragmentWithBackStack(fragment))
    }

    fun navigateToFragmentWithoutBackStack(fragment: Fragment) {
        _liveDataNavigation.value = Event(Navigation.ToFragmentWithoutBackStack(fragment))
    }

    fun navigateToBack() {
        _liveDataNavigation.value = Event(Navigation.ToBack)
    }

}