package com.example.moroz_lesson3.recyclerview.mainscreen

import com.example.moroz_lesson3.databinding.AboutUsMainScreenRvBinding
import com.example.moroz_lesson3.model.MainScreen
import com.example.moroz_lesson3.recyclerview.base.BaseMainScreenViewHolder

class AboutUsViewHolder(
    private val binding: AboutUsMainScreenRvBinding
) : BaseMainScreenViewHolder(binding.root) {

    override fun populate(mainScreen: MainScreen) {
        with(binding) {
            aboutUsTitleRv.text = mainScreen.aboutUs
            aboutUsDescriptionRv.text = mainScreen.aboutUsDescription
        }
    }

}