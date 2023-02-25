package com.example.moroz_lesson3.recyclerview.mainscreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.moroz_lesson3.databinding.AboutUsMainScreenRvBinding
import com.example.moroz_lesson3.databinding.ImageMainScreenRvBinding
import com.example.moroz_lesson3.databinding.TitleMainScreenRvBinding
import com.example.moroz_lesson3.model.MainScreen
import com.example.moroz_lesson3.recyclerview.base.BaseMainScreenViewHolder

class MainScreenAdapter : ListAdapter<MainScreen, BaseMainScreenViewHolder>(MainScreenDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseMainScreenViewHolder {
        return when (viewType) {
            0 -> {
                val binding = ImageMainScreenRvBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                ImageViewHolder(binding)
            }
            1 -> {
                val binding = TitleMainScreenRvBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                TitleViewHolder(binding)
            }
            else -> {
                val binding = AboutUsMainScreenRvBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                AboutUsViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: BaseMainScreenViewHolder, position: Int) {
        holder.populate(currentList[position])
    }

    override fun getItemViewType(position: Int): Int = currentList[position].viewType

}