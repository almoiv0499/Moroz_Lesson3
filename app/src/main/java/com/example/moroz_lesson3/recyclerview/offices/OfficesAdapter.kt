package com.example.moroz_lesson3.recyclerview.offices

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.moroz_lesson3.databinding.BelarusOfficeRvBinding
import com.example.moroz_lesson3.databinding.RussianOfficeRvBinding
import com.example.moroz_lesson3.model.Office
import com.example.moroz_lesson3.recyclerview.BaseViewHolder

class OfficesAdapter : ListAdapter<Office, BaseViewHolder>(OfficesDiffUtil()) {

    var onOfficeClickListener: ((Office) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            0 -> {
                val binding = RussianOfficeRvBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                RussianOfficeViewHolder(binding)
            }
            else -> {
                val binding = BelarusOfficeRvBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                BelarusOfficeViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.populate(currentList[position], onOfficeClickListener)
    }

    override fun getItemViewType(position: Int): Int {
        return currentList[position].viewType
    }

}