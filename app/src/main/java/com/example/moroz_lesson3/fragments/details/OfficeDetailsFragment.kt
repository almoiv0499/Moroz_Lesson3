package com.example.moroz_lesson3.fragments.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.moroz_lesson3.databinding.FragmentOfficeDetailsBinding
import com.example.moroz_lesson3.fragments.base.BaseFragment

class OfficeDetailsFragment : BaseFragment<OfficesDetailsViewModel>() {

    companion object {
        private const val ADDRESS_KEY = "address_key"
        private const val CITY_KEY = "city_key"

        fun newInstance(city: String, address: String): OfficeDetailsFragment {
            val fragment = OfficeDetailsFragment()
            val args = Bundle().apply {
                putString(CITY_KEY, city)
                putString(ADDRESS_KEY, address)
            }
            fragment.arguments = args
            return fragment
        }
    }

    private var _binding: FragmentOfficeDetailsBinding? = null
    private val binding get() = _binding!!

    override val viewModel by viewModels<OfficesDetailsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentOfficeDetailsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setCityInfoToScreen()
        navigateToOfficesFragment()
    }

    private fun setCityInfoToScreen() {
        with(binding) {
            officeDetailsToolbar.title = getCity()
            address.text = getAddress()
        }
    }

    private fun getAddress(): String {
        return arguments?.getString(ADDRESS_KEY).toString()
    }

    private fun getCity(): String {
        return arguments?.getString(CITY_KEY).toString()
    }

    private fun navigateToOfficesFragment() {
        binding.officeDetailsToolbar.setNavigationOnClickListener {
            viewModel.navigateToOfficesFragment()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}