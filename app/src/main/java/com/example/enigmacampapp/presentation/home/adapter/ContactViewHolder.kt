package com.example.enigmacampapp.presentation.home.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.enigmacampapp.databinding.CardLayoutBinding
import com.example.enigmacampapp.presentation.home.model.ContactModel

class ContactViewHolder(itemView: View, private val listener: ContactListener)
    : RecyclerView.ViewHolder(itemView) {
    val binding = CardLayoutBinding.bind(itemView)

    fun bind(contact: ContactModel) {
        binding.apply {
            tvContactName.text = contact.name
            tvContactJob.text = contact.job
            contactImage.setImageResource(contact.contactImage)
            contactDelete.setOnClickListener {
                listener.onDelete(contact)
            }
        }
    }
}

