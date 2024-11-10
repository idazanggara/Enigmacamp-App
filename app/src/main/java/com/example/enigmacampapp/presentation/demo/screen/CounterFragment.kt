package com.example.enigmacampapp.presentation.demo.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.enigmacampapp.databinding.FragmentCounterBinding
import com.example.enigmacampapp.presentation.demo.viewmodel.CounterViewModel


class CounterFragment : Fragment() {

    private lateinit var binding: FragmentCounterBinding
    private lateinit var counterViewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentCounterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        counterViewModel = ViewModelProvider(requireActivity())[CounterViewModel::class.java]
        binding.btnIncrement.setOnClickListener {
            counterViewModel.notifyIncrease()
        }

        binding.btnDecrement.setOnClickListener {
            counterViewModel.notifyDecrease()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = CounterFragment()
    }
}