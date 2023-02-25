package com.example.moroz_lesson3.recyclerview.offices

import com.example.moroz_lesson3.databinding.RussianOfficeRvBinding
import com.example.moroz_lesson3.model.Office
import com.example.moroz_lesson3.recyclerview.base.BaseViewHolder

class RussianOfficeViewHolder(
    private val binding: RussianOfficeRvBinding,
) : BaseViewHolder(binding.root) {

    override fun populate(office: Office, onOfficeClickListener: ((Office) -> Unit)?) {
        with(binding) {
            russianCity.text = office.city

            cardViewRussianLayout.setOnClickListener {
                onOfficeClickListener?.invoke(office)
            }
        }
    }

}