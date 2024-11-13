package com.example.enigmacampapp.presentation.home.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.enigmacampapp.databinding.FragmentContactBinding
import com.example.enigmacampapp.presentation.home.adapter.ContactAdapter

class ContactFragment : Fragment() {

    private  var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<ContactAdapter.ViewHolder>? = null
    private lateinit var binding: FragmentContactBinding

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
        layoutManager = LinearLayoutManager(requireContext())
        adapter = ContactAdapter()
        binding.apply {
            contactRecyclerview.layoutManager = layoutManager
            contactRecyclerview.adapter = adapter
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = ContactFragment()
    }
}