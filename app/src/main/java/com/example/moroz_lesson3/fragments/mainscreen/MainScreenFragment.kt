package com.example.moroz_lesson3.fragments.mainscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.moroz_lesson3.R
import com.example.moroz_lesson3.databinding.FragmentMainScreenBinding
import com.example.moroz_lesson3.fragments.util.CustomizeToolbar

class MainScreenFragment : Fragment(), CustomizeToolbar {

    companion object {
        fun newInstance() = MainScreenFragment()
    }

    private var _binding: FragmentMainScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentMainScreenBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun setToolbarTitle(): Int = R.string.string_home

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}