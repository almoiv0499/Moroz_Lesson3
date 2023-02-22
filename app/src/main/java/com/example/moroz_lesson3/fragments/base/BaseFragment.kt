package com.example.moroz_lesson3.fragments.base

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.moroz_lesson3.R
import com.example.moroz_lesson3.fragments.util.Navigation

abstract class BaseFragment<VM : BaseViewModel> : Fragment() {

    protected abstract val viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeNavigation()
    }

    private fun observeNavigation() {
        viewModel.liveDataNavigation.observe(viewLifecycleOwner) {event ->
            event.getContentIfNotHandled()?.let { navigation ->
                handleNavigation(navigation)
            }
        }
    }

    private fun handleNavigation(navigation: Navigation) {
        when(navigation) {
            is Navigation.ToFragmentWithoutBackStack -> {
                navigateWithoutBackStack(navigation.fragment)
            }
            is Navigation.ToFragmentWithBackStack -> {
                navigateWithBackStack(navigation.fragment)
            }
            is Navigation.ToBack -> {
                navigateBack()
            }
        }
    }

    private fun navigateBack() {
        activity?.supportFragmentManager?.popBackStack()
    }

    private fun navigateWithBackStack(fragment: Fragment) {
        activity?.let {
            it.supportFragmentManager.commit {
                replace(R.id.fragment_container, fragment)
                addToBackStack(null)
            }
        }
    }

    private fun navigateWithoutBackStack(fragment: Fragment) {
        Handler(Looper.getMainLooper()).postDelayed({
            activity?.let {
                it.supportFragmentManager.commit {
                    replace(R.id.fragment_container, fragment)
                }
            }
        }, 1000)
    }

}