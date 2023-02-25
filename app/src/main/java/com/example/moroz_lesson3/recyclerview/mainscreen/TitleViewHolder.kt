package com.example.moroz_lesson3.recyclerview.mainscreen

import com.bumptech.glide.Glide
import com.example.moroz_lesson3.R
import com.example.moroz_lesson3.databinding.TitleMainScreenRvBinding
import com.example.moroz_lesson3.model.MainScreen
import com.example.moroz_lesson3.recyclerview.base.BaseMainScreenViewHolder

class TitleViewHolder(
    private val binding: TitleMainScreenRvBinding,
) : BaseMainScreenViewHolder(binding.root) {

    override fun populate(mainScreen: MainScreen) {
        with(binding) {
            titleRv.text = mainScreen.title
            subtitleRv.text = mainScreen.subtitle

            Glide.with(binding.root)
                .load(mainScreen.logo)
                .placeholder(R.drawable.logo)
                .into(binding.logoImageViewRv)
        }
    }

}