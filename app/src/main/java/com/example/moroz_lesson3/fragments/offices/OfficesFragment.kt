package com.example.moroz_lesson3.fragments.offices

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.moroz_lesson3.R
import com.example.moroz_lesson3.activity.MainActivity
import com.example.moroz_lesson3.databinding.FragmentOfficesBinding

class OfficesFragment : Fragment() {

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

        (activity as MainActivity).checkFragment(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigateToOfficeDetailsFragment()
    }

    private fun navigateToOfficeDetailsFragment() {
        with(binding) {
            moscowOffice.setOnClickListener {
                val address = getString(R.string.moscow_address)
            }
            kazanOffice.setOnClickListener {
                val address = getString(R.string.kazan_address)
            }
            rostovOnDonOffice.setOnClickListener {
                val address = getString(R.string.rostovOnDon_address)
            }
            minskOffice.setOnClickListener {
                val address = getString(R.string.minsk_address)
            }
            gomelOffice.setOnClickListener {
                val address = getString(R.string.gomel_address)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}