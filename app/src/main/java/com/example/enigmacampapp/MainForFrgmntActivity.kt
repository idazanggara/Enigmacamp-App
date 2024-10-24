package com.example.enigmacampapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.enigmacampapp.controller.CounterHandler
import com.example.enigmacampapp.databinding.ActivityMainForFrgmntBinding
import com.example.enigmacampapp.databinding.FragmentCounter01Binding
import com.example.enigmacampapp.databinding.FragmentCounterShow01Binding

class MainForFrgmntActivity : AppCompatActivity(), CounterHandler {

    private lateinit var binding: ActivityMainForFrgmntBinding

    private lateinit var counterShowFragment: CounterShow01Fragment

    private lateinit var counterFragment: Counter01Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainForFrgmntBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val mFragmentManager = supportFragmentManager
        counterShowFragment = CounterShow01Fragment()
        counterFragment = Counter01Fragment()

        val fragmentCounter = mFragmentManager.findFragmentByTag(Counter01Fragment::class.java.simpleName)
        if(fragmentCounter !is Counter01Fragment){
            mFragmentManager
                .beginTransaction()
                .add(R.id.counter_fragment,counterFragment, Counter01Fragment::class.java.simpleName)
                .commit()
        }

        val fragmentCounterShow = mFragmentManager.findFragmentByTag(CounterShow01Fragment::class.java.simpleName)
        if(fragmentCounterShow !is CounterShow01Fragment){
            mFragmentManager
                .beginTransaction()
                .add(R.id.counter_show_fragment,counterShowFragment, CounterShow01Fragment::class.java.simpleName)
                .commit()
        }


    }

    override fun notifyShowCounter(counter: Int) {
        counterShowFragment.notifyShowCounter(counter)
    }

}


// old

//class MainForFrgmntActivity : AppCompatActivity(), CounterHandler {
////    private lateinit var  binding: ActivityMainForFrgmntBinding
////    private lateinit var fragmentCounter: Counter01Fragment
////    private lateinit var fragmentCounterShow: CounterShow01Fragment
////    private var counter: Int = 0
//
//    private lateinit var binding: ActivityMainForFrgmntBinding
//    private lateinit var counterShowFragment: CounterShow01Fragment
//
//    //---
//    // sedikit tambahan cara lain
////    private lateinit var counterShowBinding: FragmentCounterShow01Binding
////    private lateinit var counterShowFragment: CounterShow01Fragment
//    //---
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
////        setContentView(R.layout.activity_main_for_frgmnt)
//        binding = ActivityMainForFrgmntBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//
//
//
////        fragmentCounter = Counter01Fragment()
////        fragmentCounterShow = CounterShow01Fragment()
////        binding.apply {
//////            supportFragmentManager.beginTransaction().add(fragmentCounter.id, fragmentCounter).commit()
//////            supportFragmentManager.beginTransaction().add(fragmentCounterShow.id, fragmentCounterShow).commit()
////
////            supportFragmentManager.beginTransaction().add(R.id.counter_fragment, fragmentCounter).commit()
////            supportFragmentManager.beginTransaction().replace(R.id.counter_show_fragment, fragmentCounterShow).commit()
////        }
//
//        counterShowFragment = supportFragmentManager.findFragmentById(R.id.counter_show_fragment) as CounterShow01Fragment
//
//        //---
//        // code ini digunakan untuk mendapatkan instance dari showFragment yg sedang di tampilkan di activity
////        counterShowFragment = supportFragmentManager.findFragmentById(R.id.counter_show_fragment) as CounterShow01Fragment
//        // code ini mempermudah kita untuk mengakses setiap view yg ada di dalam layout counter_show_fragment
//        // dengan syarat sudah melalui instance dari counterShowFragment, ini memungkinkan kita
//        // untuk memanipulasi tampilan dan data yg ada di fragment
////        counterShowBinding = counterShowFragment.binding
//        //---
//    }
//
//    override fun notifyShowCounter(counter: Int) {
//        counterShowFragment.notifyShowCounter(counter)
//    }
//
////    fun notifyIncrease(){
////        counter++
////        Log.d("test", "NotifyIncrease $counter ++")
////        fragmentCounterShow.notifyShowCounter(counter)
//////        showCounterValue(counter)
////    }
//
////    fun notifyDecrease(){
////        if (counter > 0){
////            counter--
////            fragmentCounterShow.notifyShowCounter(counter)
//////            showCounterValue(counter)
////        } else {
////            Toast.makeText(this, "Angka tidak boleh kurang dari 0", Toast.LENGTH_SHORT).show()
////        }
////        Log.d("test", "NotifyDecrease $counter --")
////    }
//
//    //---
////    fun showCounterValue(value: Int){
////        counterShowBinding.tvCounterSecond.text = value.toString()
////    }
//    //---
//}