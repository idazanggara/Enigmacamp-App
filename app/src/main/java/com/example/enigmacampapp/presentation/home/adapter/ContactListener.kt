package com.example.enigmacampapp.presentation.home.adapter

import com.example.enigmacampapp.presentation.home.model.ContactModel

interface ContactListener {
    fun onDelete(contact: ContactModel)
}

