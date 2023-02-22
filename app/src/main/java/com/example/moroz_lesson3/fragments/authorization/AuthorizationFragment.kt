package com.example.moroz_lesson3.fragments.authorization

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.moroz_lesson3.databinding.FragmentAuthorizationBinding
import com.example.moroz_lesson3.fragments.base.BaseFragment

class AuthorizationFragment : BaseFragment<AuthorizationViewModel>() {

    companion object {
        private const val PASSWORD = "password123"
    }

    override val viewModel: AuthorizationViewModel by viewModels()
    private var _binding: FragmentAuthorizationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentAuthorizationBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        accessUsernameAndPassword()
        navigateToMainScreenFragment()
    }

    private fun accessUsernameAndPassword() {
        with(binding) {
            inputUsernameLayout.editText?.setOnKeyListener { _, keyCode, event ->
                if ((event.action == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    verifyUsernameAndPassword()
                    true
                } else {
                    false
                }
            }
            inputPasswordLayout.editText?.setOnKeyListener { _, keyCode, event ->
                if ((event.action == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    verifyUsernameAndPassword()
                    true
                } else {
                    false
                }
            }
        }
    }

    private fun verifyUsernameAndPassword() {
        with(binding) {
            val username = inputUsernameLayout.editText?.text.toString().trim()
            val password = inputPasswordLayout.editText?.text.toString().trim()
            if (username.isNotEmpty() && password == PASSWORD) {
                loginButton.isEnabled = true
                inputUsernameLayout.isErrorEnabled = false
                inputPasswordLayout.isErrorEnabled = false
            }
        }
    }

    private fun navigateToMainScreenFragment() {
        binding.loginButton.setOnClickListener {
            binding.groupVisibility.visibility = View.GONE
            binding.progressLoading.visibility = View.VISIBLE
            viewModel.navigateToMainScreenFragment()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}