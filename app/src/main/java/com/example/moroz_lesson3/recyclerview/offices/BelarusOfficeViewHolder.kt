package com.example.moroz_lesson3.recyclerview.offices

import com.example.moroz_lesson3.databinding.BelarusOfficeRvBinding
import com.example.moroz_lesson3.model.Office
import com.example.moroz_lesson3.recyclerview.base.BaseViewHolder

class BelarusOfficeViewHolder(
    private val binding: BelarusOfficeRvBinding,
) : BaseViewHolder(binding.root) {

    override fun populate(office: Office, onOfficeClickListener: ((Office) -> Unit)?) {
        with(binding) {
            belarusCity.text = office.city

            cardViewBelarusLayout.setOnClickListener {
                onOfficeClickListener?.invoke(office)
            }
        }
    }
}