package com.example.moroz_lesson3.recyclerview.vacancies

import androidx.recyclerview.widget.DiffUtil
import com.example.moroz_lesson3.model.Vacancy

class VacanciesDiffUtil : DiffUtil.ItemCallback<Vacancy>() {

    override fun areItemsTheSame(oldItem: Vacancy, newItem: Vacancy): Boolean =
        oldItem.title == newItem.title

    override fun areContentsTheSame(oldItem: Vacancy, newItem: Vacancy): Boolean =
        oldItem == newItem
}