package com.example.moroz_lesson3.recyclerview.offices

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.moroz_lesson3.databinding.OfficeRvItemBinding
import com.example.moroz_lesson3.model.Office

class OfficesAdapter : ListAdapter<Office, OfficesViewHolder>(OfficesDiffUtil()) {

    var onOfficeClickListener: ((Office) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfficesViewHolder {
        val binding = OfficeRvItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return OfficesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OfficesViewHolder, position: Int) {
        val office = currentList[position]
        holder.populate(office, onOfficeClickListener)
    }

}