package com.example.enigmacampapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.enigmacampapp.databinding.FragmentCounter01Binding
import com.google.android.material.button.MaterialButton


class Counter01Fragment : Fragment() {

    // view binding
    private lateinit var binding: FragmentCounter01Binding

    private lateinit var textView: TextView
    private lateinit var btnIncrement: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_counter01, container, false)
        // yg atas kita ganti ini untuk view binding,
        // bisa ini
//        binding = FragmentCounter01Binding.inflate(inflater, container, false)
        // atau ini
        binding = FragmentCounter01Binding.inflate(layoutInflater)
        return binding.root
    }

    // setelah layoutnya dibuat, viewnya yg di buat.
    // nah disini untuk buat viewnya di fragment
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView = view.findViewById(R.id.textCounter)
        btnIncrement = view.findViewById(R.id.btn_increase)
        btnIncrement.setOnClickListener {
            // your code here
        }
        binding.apply {
            btnDecrease.setOnClickListener {

            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = Counter01Fragment()
    }
}