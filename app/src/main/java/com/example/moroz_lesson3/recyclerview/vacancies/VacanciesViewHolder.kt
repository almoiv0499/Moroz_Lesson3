package com.example.moroz_lesson3.recyclerview.vacancies

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.moroz_lesson3.R
import com.example.moroz_lesson3.databinding.VacancyRvItemBinding
import com.example.moroz_lesson3.model.Vacancy

class VacanciesViewHolder(private val binding: VacancyRvItemBinding) : ViewHolder(binding.root) {

    fun bind(vacancy: Vacancy) {
        with(binding) {
            titleCustomView.text = vacancy.title
            subtitleCustomView.text = vacancy.subtitle
            Glide.with(binding.root)
                .load(vacancy.image)
                .fitCenter()
                .placeholder(R.drawable.logo)
                .into(binding.logoCustomView)
        }
    }

}