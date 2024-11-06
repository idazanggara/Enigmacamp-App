package com.example.enigmacampapp.presentation.demo.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.enigmacampapp.R
import com.example.enigmacampapp.databinding.FragmentCounterBinding


class CounterFragment : Fragment() {

    private lateinit var binding: FragmentCounterBinding

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
//        binding.btnIncrement.setOnClickListener {
//            mainActivity.notifyIncrease()
//        }
//
//        binding.btnDecrement.setOnClickListener {
//            mainActivity.notifyDecrease()
//        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = CounterFragment()
    }
}