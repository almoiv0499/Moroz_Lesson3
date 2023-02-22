package com.example.moroz_lesson3.fragments.vacancies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.moroz_lesson3.R
import com.example.moroz_lesson3.databinding.FragmentVacanciesBinding

class VacanciesFragment : Fragment() {

    private var _binding: FragmentVacanciesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentVacanciesBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}