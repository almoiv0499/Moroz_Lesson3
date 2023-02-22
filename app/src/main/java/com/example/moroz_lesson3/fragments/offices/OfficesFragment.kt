package com.example.moroz_lesson3.fragments.offices

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.moroz_lesson3.R
import com.example.moroz_lesson3.databinding.FragmentOfficesBinding
import com.example.moroz_lesson3.fragments.base.BaseFragment
import com.example.moroz_lesson3.fragments.base.BaseViewModel
import kotlin.math.min

class OfficesFragment : BaseFragment<BaseViewModel>() {

    companion object {
        fun newInstance() = OfficesFragment()
    }

    private var _binding: FragmentOfficesBinding? = null
    private val binding get() = _binding!!

    override val viewModel: OfficesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentOfficesBinding.inflate(inflater, container, false)

        navigateToOfficeDetailsFragment()

        return binding.root
    }

    private fun navigateToOfficeDetailsFragment() {
        with(binding) {
            moscowOffice.setOnClickListener {
                val address = getString(R.string.moscow_address)
                viewModel.navigateToOfficeDetails(moscowOffice.text.toString(), address)
            }
            kazanOffice.setOnClickListener {
                val address = getString(R.string.kazan_address)
                viewModel.navigateToOfficeDetails(kazanOffice.text.toString(), address)
            }
            rostovOnDonOffice.setOnClickListener {
                val address = getString(R.string.rostovOnDon_address)
                viewModel.navigateToOfficeDetails(rostovOnDonOffice.text.toString(), address)
            }
            minskOffice.setOnClickListener {
                val address = getString(R.string.minsk_address)
                viewModel.navigateToOfficeDetails(minskOffice.text.toString(), address)
            }
            gomelOffice.setOnClickListener {
                val address = getString(R.string.gomel_address)
                viewModel.navigateToOfficeDetails(gomelOffice.text.toString(), address)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}