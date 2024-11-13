package com.example.enigmacampapp.presentation.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.enigmacampapp.R
import com.example.enigmacampapp.presentation.home.model.ContactModel

class ContactViewModel : ViewModel() {

    private var _contactLiveData = MutableLiveData<List<ContactModel>>()
    val contactLiveData: LiveData<List<ContactModel>> get() = _contactLiveData

    // Contact Dummy
    private var contacts = arrayListOf(
        ContactModel("IDAZ ANGGARA", "Android Developer", R.drawable.ic_account_circle_contact),)

    init {
        loadDataContact()
    }

    private fun loadDataContact() {
        _contactLiveData.value = contacts
    }
}