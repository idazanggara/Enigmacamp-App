package com.example.enigmacampapp.presentation.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.enigmacampapp.R
import com.example.enigmacampapp.presentation.home.adapter.ContactListener
import com.example.enigmacampapp.presentation.home.model.ContactModel

class ContactViewModel : ViewModel(), ContactListener {

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

    fun addContact(contact: ContactModel) {
        contacts.add(contact)
        _contactLiveData.value = contacts
    }

    override fun onDelete(contact: ContactModel) {
        val contactIndex = contacts.indexOf(contact)
        contacts.removeAt(contactIndex)
        _contactLiveData.value = contacts
    }
}