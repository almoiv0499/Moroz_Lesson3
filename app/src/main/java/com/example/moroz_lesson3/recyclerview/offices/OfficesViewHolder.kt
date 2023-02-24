package com.example.moroz_lesson3.recyclerview.offices

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.moroz_lesson3.databinding.OfficeRvItemBinding
import com.example.moroz_lesson3.model.Office

class OfficesViewHolder(private val binding: OfficeRvItemBinding) : ViewHolder(binding.root) {

    fun populate(office: Office, onOfficeClickListener: ((Office) -> Unit)?) {
        with(binding) {
            cityName.text = office.city
            phoneNumber.text = office.phoneNumber

            cardViewLayout.setOnClickListener {
                onOfficeClickListener?.invoke(office)
            }
        }
    }

}