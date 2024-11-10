package com.example.enigmacampapp.presentation.demo.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.enigmacampapp.R
import com.example.enigmacampapp.databinding.FragmentQuoteShowBinding
import com.example.enigmacampapp.presentation.demo.ViewModel.MessageViewModel


class QuoteShowFragment : Fragment() {

    private lateinit var binding: FragmentQuoteShowBinding
    private lateinit var messageViewModel: MessageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentQuoteShowBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        messageViewModel = ViewModelProvider(requireActivity())[MessageViewModel::class.java]
        subscribe()
    }

    private fun subscribe() {
        messageViewModel.message.observe(viewLifecycleOwner) {
            binding.tvQuote.text = it
        }
    }

    companion object {
        fun newInstance(param1: String, param2: String) = QuoteShowFragment()
    }
}