package com.example.moroz_lesson3.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.moroz_lesson3.model.Office

abstract class BaseViewHolder(itemView: View) : ViewHolder(itemView) {

    abstract fun populate(office: Office, onOfficeClickListener: ((Office) -> Unit)? )
}