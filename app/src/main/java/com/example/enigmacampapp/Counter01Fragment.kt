package com.example.enigmacampapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.enigmacampapp.databinding.FragmentCounter01Binding
import com.google.android.material.button.MaterialButton


class Counter01Fragment : Fragment() {

    // main activity
    private lateinit var mainForFrgmntActivity: MainForFrgmntActivity

    // view binding
    private lateinit var binding: FragmentCounter01Binding

    // findViewbyId
    private lateinit var textView: TextView
    private lateinit var btnIncrement: MaterialButton

    //-Create layout, layout punyanya fragment sekarang
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainForFrgmntActivity = activity as MainForFrgmntActivity

    }

    //-Create layout juga dan set view yg ada di dalam layoutnya
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

    //-Create layout2 yg udah di set di onCreateView
    // setelah layoutnya dibuat, viewnya yg di buat.
    // nah disini untuk buat viewnya di fragment
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView = view.findViewById(R.id.textCounter)
        btnIncrement = view.findViewById(R.id.btn_increase)
        btnIncrement.setOnClickListener {
            Log.i("testFragment", "Increase Button Pressed")
            incrementCounter()
            mainForFrgmntActivity.notifyIncrease()
        }
        binding.apply {
            btnDecrease.setOnClickListener {
                Log.i("testFragment", "Decrease Button Pressed")
                decrementCounter()
                mainForFrgmntActivity.notifyDecrease()
            }
        }
    }

    private fun incrementCounter(){
        Toast.makeText( requireContext(), "Anda Menambahkan Angka", Toast.LENGTH_SHORT).show()
    }

    private fun decrementCounter(){
        Toast.makeText( requireContext(), "Anda Mengurangkan Angka nya", Toast.LENGTH_SHORT).show()

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = Counter01Fragment()
    }
}