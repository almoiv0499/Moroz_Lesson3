package com.example.moroz_lesson3.fragments.authorization

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.moroz_lesson3.R
import com.example.moroz_lesson3.activity.MainActivity
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

        (activity as MainActivity).checkFragment(this)
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
                        validatePassword()
                    }
                    R.id.input_username -> {
                        validateUsername()
                    }
                }

            }

            override fun afterTextChanged(s: Editable?) {
            }
        }
    }

    private fun validateUsername(): Boolean {
        val username = binding.inputUsername.text.toString().trim()
        return if (username.length > 3) {
            binding.inputUsernameLayout.error = ""
            true
        } else {
            binding.inputUsernameLayout.error = "Symbols count less 3"
            false
        }
    }

    private fun validatePassword(): Boolean {
        val password = binding.inputPassword.text.toString().trim()
        return if (password == PASSWORD) {
            binding.inputPasswordLayout.error = ""
            binding.loginButton.isEnabled = true
            true
        } else {
            binding.inputPasswordLayout.error = "Wrong password"
            false
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