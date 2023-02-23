package com.example.moroz_lesson3.fragments.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.moroz_lesson3.activity.MainActivity
import com.example.moroz_lesson3.databinding.FragmentOfficeDetailsBinding
import com.example.moroz_lesson3.model.Office
import com.example.moroz_lesson3.model.parcelable

class OfficeDetailsFragment : Fragment() {

    companion object {
        private const val OFFICE_KEY = "office_key"

        fun newInstance(office: Office): OfficeDetailsFragment {
            val fragment = OfficeDetailsFragment()
            val args = Bundle().apply {
                putParcelable(OFFICE_KEY, office)
            }
            fragment.arguments = args
            return fragment
        }
    }

    private var _binding: FragmentOfficeDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentOfficeDetailsBinding.inflate(inflater, container, false)

        (activity as MainActivity).checkFragment(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setCityInfoToScreen()
        navigateToOfficesFragment()
    }

    private fun setCityInfoToScreen() {
        val office = getOfficeData()
        if (office != null) {
            with(binding) {
                officeDetailsToolbar.title = office.city
                address.text = office.address
            }
        }
    }

    private fun getOfficeData(): Office? {
        return arguments?.parcelable(OFFICE_KEY)
    }

    private fun navigateToOfficesFragment() {
        binding.officeDetailsToolbar.setNavigationOnClickListener {
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}