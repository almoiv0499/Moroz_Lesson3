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

        initOfficesRecyclerView()
    }

    private fun initOfficesRecyclerView() {
        with(binding.recyclerViewOffices) {
            setHasFixedSize(true)
            adapter = officeAdapter
        }
    }

    private fun navigateToOfficeDetails(office: Office) {
        navigation().navigateToOfficesDetails(office)
    }

    override fun setToolbarTitle(): Int = R.string.string_offices

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun mockOfficesList(): List<Office> {
        val offices = mutableListOf<Office>()
        offices.add(
            Office(
                city = getString(R.string.string_moscow),
                address = getString(R.string.moscow_address),
                phoneNumber = getString(R.string.phone_number),
            )
        )
        offices.add(
            Office(
                city = getString(R.string.string_kazan),
                address = getString(R.string.kazan_address),
                phoneNumber = getString(R.string.phone_number)
            )
        )
        offices.add(
            Office(
                city = getString(R.string.string_rostov_on_don),
                address = getString(R.string.rostovOnDon_address),
                phoneNumber = getString(R.string.phone_number)
            )
        )
        offices.add(
            Office(
                city = getString(R.string.string_minsk),
                address = getString(R.string.minsk_address),
                phoneNumber = getString(R.string.phone_number),
                viewType = 1
            )
        )
        offices.add(
            Office(
                city = getString(R.string.string_gomel),
                address = getString(R.string.gomel_address),
                phoneNumber = getString(R.string.phone_number),
                viewType = 1
            )
        )
        return offices
    }
}