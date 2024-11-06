package com.example.enigmacampapp.presentation.materialBeforeNav

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.enigmacampapp.databinding.FragmentCounterShow01Binding

class CounterShow01Fragment : Fragment() {
    lateinit var binding: FragmentCounterShow01Binding

    var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_counter_show01, container, false)
        binding = FragmentCounterShow01Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notifyShowCounter(counter)
    }

    fun notifyShowCounter(counter: Int) {
        binding.apply {
            tvCounter.text = counter.toString()
            tvCounter.setTextColor(
                when {
                    counter > 20 -> Color.RED
                    counter > 10 -> Color.GREEN
                    else -> Color.BLACK
                }
            )
        }

        Log.i("testShowFragment", "showCounter $counter")
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = CounterShow01Fragment()
        var EXTRA_VALUE = "extra_value"
    }
}