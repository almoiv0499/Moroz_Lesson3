package com.example.moroz_lesson3.recyclerview.mainscreen

import com.bumptech.glide.Glide
import com.example.moroz_lesson3.R
import com.example.moroz_lesson3.databinding.ImageMainScreenRvBinding
import com.example.moroz_lesson3.model.MainScreen
import com.example.moroz_lesson3.recyclerview.base.BaseMainScreenViewHolder

class ImageViewHolder(
    private val binding: ImageMainScreenRvBinding
) : BaseMainScreenViewHolder(binding.root) {

    override fun populate(mainScreen: MainScreen) {
        Glide.with(binding.root)
            .load(mainScreen.image)
            .placeholder(R.drawable.logo)
            .into(binding.welcomeImageViewRv)
    }

}