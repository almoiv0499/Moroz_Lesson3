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
import com.example.moroz_lesson3.recyclerview.offices.OfficesAdapter

class OfficesFragment : Fragment(), CustomizeToolbar {

    companion object {
        fun newInstance() = OfficesFragment()
    }

    private var _binding: FragmentOfficesBinding? = null
    private val binding get() = _binding!!

    private val officeAdapter by lazy(LazyThreadSafetyMode.NONE) {
        OfficesAdapter().apply {
            submitList(mockOfficesList())
            onOfficeClickListener = {office ->
                navigateToOfficeDetails(office)
            }
        }
    }

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
        initOfficesRecyclerView()
    }

    private fun initOfficesRecyclerView() {
        with(binding.recyclerViewOffices) {
            setHasFixedSize(true)
            adapter = officeAdapter
        }
    }

    private fun navigateToOfficeDetailsFragment() {
//        with(binding) {
//            moscowOffice.setOnClickListener {
//                val city = getString(R.string.string_moscow)
//                val address = getString(R.string.moscow_address)
//                val phoneNumber = getString(R.string.phone_number)
//                navigateToOfficeDetails(city, address, phoneNumber)
//            }
//            kazanOffice.setOnClickListener {
//                val city = getString(R.string.string_kazan)
//                val address = getString(R.string.kazan_address)
//                val phoneNumber = getString(R.string.phone_number)
//                navigateToOfficeDetails(city, address, phoneNumber)
//            }
//            rostovOnDonOffice.setOnClickListener {
//                val city = getString(R.string.string_rostov_on_don)
//                val address = getString(R.string.rostovOnDon_address)
//                val phoneNumber = getString(R.string.phone_number)
//                navigateToOfficeDetails(city, address, phoneNumber)
//            }
//            minskOffice.setOnClickListener {
//                val city = getString(R.string.string_minsk)
//                val address = getString(R.string.minsk_address)
//                val phoneNumber = getString(R.string.phone_number)
//                navigateToOfficeDetails(city, address, phoneNumber)
//            }
//            gomelOffice.setOnClickListener {
//                val city = getString(R.string.string_gomel)
//                val address = getString(R.string.gomel_address)
//                val phoneNumber = getString(R.string.phone_number)
//                navigateToOfficeDetails(city, address, phoneNumber)
//            }
//        }
    }

    private fun navigateToOfficeDetails(office: Office) {
        navigation().navigateToOfficesDetails(office)
    }

//    private fun navigateToOfficeDetails(city: String, address: String, phoneNumber: String) {
//        val office = Office(city, address, phoneNumber)
//        navigation().navigateToOfficesDetails(office)
//    }

    override fun setToolbarTitle(): Int = R.string.string_offices

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun mockOfficesList(): List<Office> {
        val offices = mutableListOf<Office>()
        offices.add(
            Office(
                getString(R.string.string_moscow),
                getString(R.string.moscow_address),
                getString(R.string.phone_number)
            )
        )
        offices.add(
            Office(
                getString(R.string.string_kazan),
                getString(R.string.kazan_address),
                getString(R.string.phone_number)
            )
        )
        offices.add(
            Office(
                getString(R.string.string_rostov_on_don),
                getString(R.string.rostovOnDon_address),
                getString(R.string.phone_number)
            )
        )
        offices.add(
            Office(
                getString(R.string.string_minsk),
                getString(R.string.minsk_address),
                getString(R.string.phone_number)
            )
        )
        offices.add(
            Office(
                getString(R.string.string_gomel),
                getString(R.string.gomel_address),
                getString(R.string.phone_number)
            )
        )
        return offices
    }
}