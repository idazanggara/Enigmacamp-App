package com.example.enigmacampapp.presentation.home.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.enigmacampapp.R
import com.example.enigmacampapp.databinding.FragmentContactBinding
import com.example.enigmacampapp.presentation.home.adapter.ContactAdapter
import com.example.enigmacampapp.presentation.home.model.ContactModel

class ContactFragment : Fragment() {

//    private  var layoutManager: RecyclerView.LayoutManager? = null
//    private var adapter: RecyclerView.Adapter<ContactAdapter.ViewHolder>? = null
    private lateinit var binding: FragmentContactBinding
    private lateinit var cAdapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentContactBinding.inflate(inflater, container, false)
        return binding.root
//        return inflater.inflate(R.layout.fragment_contact,container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        layoutManager = LinearLayoutManager(requireContext())
//        adapter = ContactAdapter()
//        binding.apply {
//            contactRecyclerview.layoutManager = layoutManager
//            contactRecyclerview.adapter = adapter
//        }
        binding.apply {
            cAdapter = ContactAdapter()
            cAdapter.contactsList.addAll(getContactFromDB())
//            addContact.setOnClickListener {
//                findNavController().navigate(R.id.action_contactFragment_to_formContactFragment)
//            }
            contactRecyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = cAdapter
            }
        }

    }

    private fun getContactFromDB(): List<ContactModel> {
        return arrayListOf(
            ContactModel("IDAZ ANGGARA", "Android Developer", R.drawable.ic_account_circle_contact),
            ContactModel("JOAN MIL", "Frontend Developer", R.drawable.ic_account_circle_contact),
            ContactModel("KASANDRA LEE", "Golang Developer", R.drawable.ic_account_circle_contact),
        )
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = ContactFragment()
    }
}