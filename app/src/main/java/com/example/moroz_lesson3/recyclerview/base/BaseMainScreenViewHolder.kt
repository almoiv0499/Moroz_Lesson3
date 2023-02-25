package com.example.moroz_lesson3.recyclerview.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.moroz_lesson3.model.MainScreen

abstract class BaseMainScreenViewHolder(itemView: View) : ViewHolder(itemView) {

    abstract fun populate(mainScreen: MainScreen)

}