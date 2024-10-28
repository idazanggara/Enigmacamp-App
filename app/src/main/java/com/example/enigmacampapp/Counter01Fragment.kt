package com.example.enigmacampapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.enigmacampapp.controller.CounterHandler
import com.example.enigmacampapp.databinding.FragmentCounter01Binding
import com.google.android.material.button.MaterialButton


class Counter01Fragment : Fragment() {

    // view binding
    private lateinit var binding: FragmentCounter01Binding

    // User Interface
    private lateinit var counterHandler: CounterHandler
    // untuk nilainya bebas mau di mana, bisa di counterFragment, di activity atau di counterShowFragment
    private var counter = 0;

    //-Create layout, layout punyanya fragment sekarang
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        counterHandler = activity as CounterHandler

    }

    //-Create layout juga dan set view yg ada di dalam layoutnya
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCounter01Binding.inflate(layoutInflater)
        return binding.root
    }

    //-Create layout2 yg udah di set di onCreateView
    // setelah layoutnya dibuat, viewnya yg di buat.
    // nah disini untuk buat viewnya di fragment
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var btnIncrement = view.findViewById<MaterialButton>(R.id.btn_increase)
        btnIncrement.setOnClickListener {
            counterHandler.notifyIncrease()

        }
        binding.apply {
            btnDecrease.setOnClickListener {
                counterHandler.notifyDecrease()
            }
        }


    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = Counter01Fragment()
    }
}

// Fragment with interface
//class Counter01Fragment : Fragment() {
//
//    // view binding
//    lateinit var binding: FragmentCounter01Binding
//
//    // User Interface
//    private lateinit var counterHandler: CounterHandler
//    // untuk nilainya bebas mau di mana, bisa di counterFragment, di activity atau di counterShowFragment
//    private var counter = 0;
//
//    //-Create layout, layout punyanya fragment sekarang
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        counterHandler = activity as CounterHandler
//
//    }
//
//    //-Create layout juga dan set view yg ada di dalam layoutnya
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = FragmentCounter01Binding.inflate(layoutInflater)
//        return binding.root
//    }
//
//    //-Create layout2 yg udah di set di onCreateView
//    // setelah layoutnya dibuat, viewnya yg di buat.
//    // nah disini untuk buat viewnya di fragment
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        var textView = view.findViewById<TextView>(R.id.textCounter)
//        var btnIncrement = view.findViewById<MaterialButton>(R.id.btn_increase)
//        btnIncrement.setOnClickListener {
//            counter++
//            counterHandler.notifyShowCounter(counter)
//            Log.i("testCounterFragment", "Nilai counter di Counter Fragment Plus $counter")
//
//        }
//        binding.apply {
//            btnDecrease.setOnClickListener {
//                if (counter > 0){
//                    counter--
//                    counterHandler.notifyShowCounter(counter)
//                } else {
//                    Toast.makeText(requireContext(), "Angka tidak boleh kurang dari 0", Toast.LENGTH_SHORT).show()
//                }
//
//                // tambahan, ini mengubah fragment Shownya setiap di click
//                val fragmentCounterShow = CounterShow01Fragment()
//                val bundleToShowFragment = Bundle()
//                bundleToShowFragment.putString(CounterShow01Fragment.EXTRA_VALUE, "My Value From Counter Fragment $counter")
//                fragmentCounterShow.arguments = bundleToShowFragment
//
//                parentFragmentManager.beginTransaction().apply {
//                    replace(R.id.counter_show_fragment,fragmentCounterShow, CounterShow01Fragment::class.java.simpleName)
//                    commit()
//                }
//            }
//        }
//
//
//    }
//
//    companion object {
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) = Counter01Fragment()
//    }
//}

// old
//class Counter01Fragment : Fragment() {
//
//    // main activity
////    private lateinit var mainForFrgmntActivity: MainForFrgmntActivity
//
//    // view binding
//    lateinit var binding: FragmentCounter01Binding
//
//    // findViewbyId
//    private lateinit var textView: TextView
//    private lateinit var btnIncrement: MaterialButton
//
//    // User Interface
//    private lateinit var counterHandler: CounterHandler
//    private var counter = 0;
//
//    //-Create layout, layout punyanya fragment sekarang
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
////        mainForFrgmntActivity = activity as MainForFrgmntActivity
//
//        counterHandler = activity as CounterHandler
//
//    }
//
//    //-Create layout juga dan set view yg ada di dalam layoutnya
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
////        return inflater.inflate(R.layout.fragment_counter01, container, false)
//        // yg atas kita ganti ini untuk view binding,
//        // bisa ini
////        binding = FragmentCounter01Binding.inflate(inflater, container, false)
//        // atau ini
//        binding = FragmentCounter01Binding.inflate(layoutInflater)
//        return binding.root
//    }
//
//    //-Create layout2 yg udah di set di onCreateView
//    // setelah layoutnya dibuat, viewnya yg di buat.
//    // nah disini untuk buat viewnya di fragment
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        textView = view.findViewById(R.id.textCounter)
//        btnIncrement = view.findViewById(R.id.btn_increase)
//        btnIncrement.setOnClickListener {
////            Log.i("testFragment", "Increase Button Pressed")
//            incrementCounter()
////            mainForFrgmntActivity.notifyIncrease()
//        }
//        binding.apply {
//            btnDecrease.setOnClickListener {
////                Log.i("testFragment", "Decrease Button Pressed")
//                decrementCounter()
////                mainForFrgmntActivity.notifyDecrease()
//            }
//        }
//    }
//
//    private fun incrementCounter(){
//        Log.i("test", "Increase Button pressed")
//        counter++
//        counterHandler.notifyShowCounter(counter)
////        Toast.makeText( requireContext(), "Anda Menambahkan Angka", Toast.LENGTH_SHORT).show()
//    }
//
//    private fun decrementCounter(){
//        Log.i("test", "Decrease Button pressed")
//        if (counter > 0){
//            counter--
//            counterHandler.notifyShowCounter(counter)
//        } else {
//            Toast.makeText(requireContext(), "Angka tidak boleh kurang dari 0", Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    companion object {
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) = Counter01Fragment()
//    }
//}