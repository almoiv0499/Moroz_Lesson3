package com.example.moroz_lesson3.fragments.offices

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.moroz_lesson3.R
import com.example.moroz_lesson3.databinding.FragmentOfficesBinding
import com.example.moroz_lesson3.fragments.util.CustomizeToolbar
import com.example.moroz_lesson3.fragments.util.navigation
import com.example.moroz_lesson3.model.Office

class OfficesFragment : Fragment(), CustomizeToolbar {

    companion object {
        fun newInstance() = OfficesFragment()
    }

    private var _binding: FragmentOfficesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentOfficesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigateToOfficeDetailsFragment()
    }

    private fun navigateToOfficeDetailsFragment() {
        with(binding) {
            moscowOffice.setOnClickListener {
                val city = getString(R.string.string_moscow)
                val address = getString(R.string.moscow_address)
                val phoneNumber = getString(R.string.phone_number)
                navigateToOfficeDetails(city, address, phoneNumber)
            }
            kazanOffice.setOnClickListener {
                val city = getString(R.string.string_kazan)
                val address = getString(R.string.kazan_address)
                val phoneNumber = getString(R.string.phone_number)
                navigateToOfficeDetails(city, address, phoneNumber)
            }
            rostovOnDonOffice.setOnClickListener {
                val city = getString(R.string.string_rostov_on_don)
                val address = getString(R.string.rostovOnDon_address)
                val phoneNumber = getString(R.string.phone_number)
                navigateToOfficeDetails(city, address, phoneNumber)
            }
            minskOffice.setOnClickListener {
                val city = getString(R.string.string_minsk)
                val address = getString(R.string.minsk_address)
                val phoneNumber = getString(R.string.phone_number)
                navigateToOfficeDetails(city, address, phoneNumber)
            }
            gomelOffice.setOnClickListener {
                val city = getString(R.string.string_gomel)
                val address = getString(R.string.gomel_address)
                val phoneNumber = getString(R.string.phone_number)
                navigateToOfficeDetails(city, address, phoneNumber)
            }
        }
    }

    private fun navigateToOfficeDetails(city: String, address: String, phoneNumber: String) {
        val office = Office(city, address, phoneNumber)
        navigation().navigateToOfficesDetails(office)
    }

    override fun setToolbarTitle(): Int = R.string.string_offices

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}