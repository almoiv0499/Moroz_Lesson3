package com.example.moroz_lesson3.fragments.mainscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.moroz_lesson3.R
import com.example.moroz_lesson3.databinding.FragmentMainScreenBinding
import com.example.moroz_lesson3.fragments.util.CustomizeToolbar
import com.example.moroz_lesson3.model.MainScreen
import com.example.moroz_lesson3.recyclerview.mainscreen.MainScreenAdapter

class MainScreenFragment : Fragment(), CustomizeToolbar {

    companion object {
        fun newInstance() = MainScreenFragment()
    }

    private var _binding: FragmentMainScreenBinding? = null
    private val binding get() = _binding!!

    private val mainScreenAdapter by lazy(LazyThreadSafetyMode.NONE) {
        MainScreenAdapter().apply {
            submitList(mockMainScreenList())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentMainScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        with(binding.recyclerViewMainScreen) {
            setHasFixedSize(true)
            adapter = mainScreenAdapter
        }
    }

    override fun setToolbarTitle(): Int = R.string.string_home

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun mockMainScreenList(): List<MainScreen> {
        val screens = mutableListOf<MainScreen>()
        screens.add(
            MainScreen(
                viewType = 0
            )
        )
        screens.add(
            MainScreen(
                title = getString(R.string.string_title),
                subtitle = getString(R.string.string_subtitle),
                viewType = 1
            )
        )
        screens.add(
            MainScreen(
                aboutUs = getString(R.string.about_us),
                aboutUsDescription = getString(R.string.string_about_us_description),
                viewType = 2
            )
        )
        return screens
    }

}