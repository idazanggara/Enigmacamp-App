package com.example.enigmacampapp.presentation.home.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.enigmacampapp.R
import com.example.enigmacampapp.databinding.FragmentFormContactBinding
import com.example.enigmacampapp.presentation.home.model.ContactModel
import com.example.enigmacampapp.presentation.home.viewmodel.ContactViewModel

class FormContactFragment : Fragment() {

    private lateinit var binding: FragmentFormContactBinding
    private lateinit var contactViewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentFormContactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        binding.apply {
            backToContactList.setOnClickListener {
                findNavController().navigate(R.id.action_formContactFragment_to_contactFragment)
            }

            btnSave.setOnClickListener {
                contactViewModel.addContact(saveContact())
                findNavController().navigate(R.id.action_formContactFragment_to_contactFragment)
            }
        }
    }

    private fun initViewModel() {
        contactViewModel = ViewModelProvider(requireActivity())[ContactViewModel::class.java]
    }

    private fun saveContact(): ContactModel {
        return ContactModel(
            binding.teContactName.text.toString(),
            binding.teContactJob.text.toString(),
            R.drawable.ic_account_circle_contact)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) = FormContactFragment()
    }
}