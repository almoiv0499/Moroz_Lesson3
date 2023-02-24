package com.example.moroz_lesson3.fragments.vacancies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.moroz_lesson3.R
import com.example.moroz_lesson3.databinding.FragmentVacanciesBinding
import com.example.moroz_lesson3.fragments.util.CustomizeToolbar
import com.example.moroz_lesson3.model.Vacancy
import com.example.moroz_lesson3.recyclerview.vacancies.VacanciesAdapter

class VacanciesFragment : Fragment(), CustomizeToolbar {

    companion object {
        fun newInstance() = VacanciesFragment()
    }

    private var _binding: FragmentVacanciesBinding? = null
    private val binding get() = _binding!!

    private val vacanciesAdapter by lazy(LazyThreadSafetyMode.NONE) {
        VacanciesAdapter().apply {
            submitList(mockVacanciesList())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentVacanciesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        with(binding.recyclerViewVacancies) {
            setHasFixedSize(true)
            adapter = vacanciesAdapter
        }
    }

    override fun setToolbarTitle(): Int = R.string.string_vacancies

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun mockVacanciesList(): List<Vacancy> {
        val vacancy = mutableListOf<Vacancy>()
        vacancy.add(javaDeveloperVacancy())
        vacancy.add(androidDeveloperVacancy())
        vacancy.add(javaScriptDeveloperVacancy())
        vacancy.add(androidDeveloperVacancy())
        vacancy.add(javaDeveloperVacancy())
        vacancy.add(javaScriptDeveloperVacancy())
        vacancy.add(androidDeveloperVacancy())
        vacancy.add(javaDeveloperVacancy())
        vacancy.add(javaScriptDeveloperVacancy())
        vacancy.add(javaScriptDeveloperVacancy())
        vacancy.add(javaDeveloperVacancy())
        vacancy.add(androidDeveloperVacancy())
        vacancy.add(javaScriptDeveloperVacancy())
        vacancy.add(javaDeveloperVacancy())
        vacancy.add(androidDeveloperVacancy())
        vacancy.add(javaScriptDeveloperVacancy())
        vacancy.add(javaDeveloperVacancy())
        vacancy.add(javaScriptDeveloperVacancy())
        vacancy.add(androidDeveloperVacancy())
        vacancy.add(androidDeveloperVacancy())
        return vacancy
    }

    private fun javaDeveloperVacancy(): Vacancy {
        val title = getString(R.string.string_third_vacancies_title)
        val subtitle = getString(R.string.string_third_vacancies_subtitle)
        val image = R.drawable.ic_java
        return Vacancy(title, subtitle, image)
    }

    private fun javaScriptDeveloperVacancy(): Vacancy {
        val title = getString(R.string.string_second_vacancies_title)
        val subtitle = getString(R.string.string_second_vacancies_subtitle)
        val image = R.drawable.ic_java_script
        return Vacancy(title, subtitle, image)
    }

    private fun androidDeveloperVacancy(): Vacancy {
        val title = getString(R.string.string_first_vacancies_title)
        val subtitle = getString(R.string.string_first_vacancies_subtitle)
        val image = R.drawable.ic_android
        return Vacancy(title, subtitle, image)
    }
}