package com.example.moroz_lesson3.fragments.util

import android.widget.Filter
import com.example.moroz_lesson3.model.Vacancy
import com.example.moroz_lesson3.recyclerview.vacancies.VacanciesAdapter

class FilterClass {

    companion object {
        fun filter(
            filteredVacancies: List<Vacancy>,
            adapter: VacanciesAdapter,
        ): Filter = object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val temp = mutableListOf<Vacancy>()
                if (constraint == null || constraint.isEmpty()) {
                    temp.addAll(filteredVacancies)
                } else {
                    val pattern = constraint.toString().lowercase().trim()
                    for (item in filteredVacancies) {
                        if (item.title.lowercase().contains(pattern)) {
                            temp.add(item)
                        }
                    }
                }
                val results = FilterResults()
                results.values = temp
                return results
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                adapter.submitList(results?.values as List<Vacancy>)
            }
        }
    }

}