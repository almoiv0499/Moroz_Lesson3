package com.example.moroz_lesson3.recyclerview.mainscreen

import androidx.recyclerview.widget.DiffUtil
import com.example.moroz_lesson3.model.MainScreen

class MainScreenDiffUtil : DiffUtil.ItemCallback<MainScreen>() {

    override fun areItemsTheSame(oldItem: MainScreen, newItem: MainScreen): Boolean =
        oldItem.title == newItem.title

    override fun areContentsTheSame(oldItem: MainScreen, newItem: MainScreen): Boolean =
        oldItem == newItem
}