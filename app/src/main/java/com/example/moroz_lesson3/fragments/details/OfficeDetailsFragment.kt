package com.example.moroz_lesson3.fragments.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.moroz_lesson3.R
import com.example.moroz_lesson3.databinding.FragmentOfficeDetailsBinding
import com.example.moroz_lesson3.fragments.util.CustomizeOfficeToolbar
import com.example.moroz_lesson3.model.Office
import com.example.moroz_lesson3.model.parcelable

class OfficeDetailsFragment : Fragment(), CustomizeOfficeToolbar {

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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setCityInfoToScreen()
    }

    private fun setCityInfoToScreen() {
        val office = getOfficeData()
        if (office != null) {
            with(binding) {
                address.text = office.address
                phoneNumber.text = office.phoneNumber
            }
        }
    }

    private fun getOfficeData(): Office? {
        return arguments?.parcelable(OFFICE_KEY)
    }

    override fun setToolbarTitle(): Int {
        val office = getOfficeData()
        return if (office != null) {
            getCityName(office)
        } else {
            R.string.string_offices
        }
    }

    private fun getCityName(office: Office): Int = when (office.city) {
        getString(R.string.string_moscow) -> R.string.string_moscow
        getString(R.string.string_kazan) -> R.string.string_kazan
        getString(R.string.string_rostov_on_don) -> R.string.string_rostov_on_don
        getString(R.string.string_minsk) -> R.string.string_minsk
        getString(R.string.string_gomel) -> R.string.string_gomel
        else -> R.string.string_offices
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}