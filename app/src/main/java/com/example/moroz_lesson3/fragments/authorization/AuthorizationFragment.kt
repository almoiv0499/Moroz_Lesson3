package com.example.moroz_lesson3.fragments.authorization

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.moroz_lesson3.R
import com.example.moroz_lesson3.databinding.FragmentAuthorizationBinding
import com.example.moroz_lesson3.fragments.util.CustomizeToolbar
import com.example.moroz_lesson3.fragments.util.navigation

class AuthorizationFragment : Fragment(), CustomizeToolbar {

    companion object {
        private const val USERNAME = "aleks"
        private const val PASSWORD = "password123"
        private const val EMPTY_STRING = ""
    }

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

        setListenersToUsernameAndPassword()
        navigateToMainScreenFragment()
    }

    private fun setListenersToUsernameAndPassword() {
        with(binding) {
            inputPasswordLayout.editText?.addTextChangedListener(textWatcher(binding.inputPassword))
            inputUsernameLayout.editText?.addTextChangedListener(textWatcher(binding.inputUsername))
        }
    }

    private fun textWatcher(view: View): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                when (view.id) {
                    R.id.input_password -> {
                        validateUsernameAndPassword()
                    }
                    R.id.input_username -> {
                        validateUsernameAndPassword()
                    }
                }

            }

            override fun afterTextChanged(s: Editable?) {
            }
        }
    }

    private fun validateUsernameAndPassword() {
        binding.loginButton.isEnabled = validateUsername() && validatePassword()
    }

    private fun validateUsername(): Boolean {
        val username = binding.inputUsername.text.toString().trim()
        return if (username == USERNAME) {
            binding.inputUsernameLayout.error = EMPTY_STRING
            true
        } else {
            binding.inputUsernameLayout.error = getString(R.string.editText_username_error)
            false
        }
    }

    private fun validatePassword(): Boolean {
        val password = binding.inputPassword.text.toString().trim()
        return if (password == PASSWORD) {
            binding.inputPasswordLayout.error = EMPTY_STRING
            true
        } else {
            binding.inputPasswordLayout.error = getString(R.string.editText_password_error)
            false
        }
    }

    private fun navigateToMainScreenFragment() {
        binding.loginButton.setOnClickListener {
            binding.groupVisibility.visibility = View.GONE
            binding.progressLoading.visibility = View.VISIBLE
            navigation().navigateFromAuthorizationToMainScreen()
        }
    }

    override fun setToolbarTitle(): Int = R.string.login_title

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}