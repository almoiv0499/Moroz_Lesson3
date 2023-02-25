package com.example.moroz_lesson3.recyclerview.vacancies

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.ListAdapter
import com.example.moroz_lesson3.databinding.VacancyRvItemBinding
import com.example.moroz_lesson3.fragments.util.FilterClass
import com.example.moroz_lesson3.model.Vacancy

class VacanciesAdapter : ListAdapter<Vacancy, VacanciesViewHolder>(VacanciesDiffUtil()), Filterable {

    private var filteredVacancies = mutableListOf<Vacancy>()

    fun setFilteredVacancies(filtered: List<Vacancy>) {
        submitList(filtered)
        filteredVacancies = ArrayList(filtered)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VacanciesViewHolder {
        val binding = VacancyRvItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return VacanciesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VacanciesViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    override fun getFilter(): Filter = FilterClass.filter(filteredVacancies, this)
}