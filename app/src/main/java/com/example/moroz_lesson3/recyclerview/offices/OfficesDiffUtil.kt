package com.example.moroz_lesson3.recyclerview.offices

import androidx.recyclerview.widget.DiffUtil
import com.example.moroz_lesson3.model.Office

class OfficesDiffUtil : DiffUtil.ItemCallback<Office>() {

    override fun areItemsTheSame(oldItem: Office, newItem: Office): Boolean =
        oldItem.city == newItem.city

    override fun areContentsTheSame(oldItem: Office, newItem: Office): Boolean = oldItem == newItem
}