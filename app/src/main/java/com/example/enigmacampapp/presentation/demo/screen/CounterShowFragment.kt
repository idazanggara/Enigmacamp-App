package com.example.enigmacampapp.presentation.demo.screen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.enigmacampapp.R
import com.example.enigmacampapp.databinding.FragmentCounterShowBinding
import com.example.enigmacampapp.presentation.demo.ViewModel.CounterViewModel


class CounterShowFragment : Fragment() {

    private lateinit var binding: FragmentCounterShowBinding
    private lateinit var counterVIewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCounterShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        counterVIewModel = ViewModelProvider(requireActivity())[CounterViewModel::class.java]
//        binding.tvCounter.text = counterVIewModel.counter.toString()
        subscribe()
        Log.i("test", "counterViewModel.counter: ${counterVIewModel.counter}")
    }

    private fun subscribe() {
        counterVIewModel.counter.observe(viewLifecycleOwner) {
            binding.tvCounter.text = it.toString()
        }
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = CounterShowFragment()
    }
}