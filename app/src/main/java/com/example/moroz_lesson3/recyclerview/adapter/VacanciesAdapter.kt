package com.example.moroz_lesson3.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.moroz_lesson3.databinding.VacancyRvItemBinding
import com.example.moroz_lesson3.model.Vacancy
import com.example.moroz_lesson3.recyclerview.diffutil.VacanciesDiffUtil
import com.example.moroz_lesson3.recyclerview.viewholder.VacanciesViewHolder

class VacanciesAdapter : ListAdapter<Vacancy, VacanciesViewHolder>(VacanciesDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VacanciesViewHolder {
        val binding = VacancyRvItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return VacanciesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VacanciesViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

}