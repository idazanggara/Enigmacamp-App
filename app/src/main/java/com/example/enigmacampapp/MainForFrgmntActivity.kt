package com.example.enigmacampapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.enigmacampapp.databinding.ActivityMainForFrgmntBinding
import com.example.enigmacampapp.databinding.FragmentCounterShow01Binding

class MainForFrgmntActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainForFrgmntBinding
    private lateinit var fragmentCounter: Counter01Fragment
    private lateinit var fragmentCounterShow: CounterShow01Fragment
    private var counter: Int = 0

    //---
    // sedikit tambahan cara lain
//    private lateinit var counterShowBinding: FragmentCounterShow01Binding
//    private lateinit var counterShowFragment: CounterShow01Fragment
    //---


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_main_for_frgmnt)
        binding = ActivityMainForFrgmntBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        fragmentCounter = Counter01Fragment()
        fragmentCounterShow = CounterShow01Fragment()
        binding.apply {
//            supportFragmentManager.beginTransaction().add(fragmentCounter.id, fragmentCounter).commit()
//            supportFragmentManager.beginTransaction().add(fragmentCounterShow.id, fragmentCounterShow).commit()

            supportFragmentManager.beginTransaction().add(R.id.counter_fragment, fragmentCounter).commit()
            supportFragmentManager.beginTransaction().replace(R.id.counter_show_fragment, fragmentCounterShow).commit()

        }

        //---
        // code ini digunakan untuk mendapatkan instance dari showFragment yg sedang di tampilkan di activity
//        counterShowFragment = supportFragmentManager.findFragmentById(R.id.counter_show_fragment) as CounterShow01Fragment
        // code ini mempermudah kita untuk mengakses setiap view yg ada di dalam layout counter_show_fragment
        // dengan syarat sudah melalui instance dari counterShowFragment, ini memungkinkan kita
        // untuk memanipulasi tampilan dan data yg ada di fragment
//        counterShowBinding = counterShowFragment.binding
        //---
    }

    fun notifyIncrease(){
        counter++
        Log.d("test", "NotifyIncrease $counter ++")
        fragmentCounterShow.notifyShowCounter(counter)
//        showCounterValue(counter)
    }

    fun notifyDecrease(){
        if (counter > 0){
            counter--
            fragmentCounterShow.notifyShowCounter(counter)
//            showCounterValue(counter)
        } else {
            Toast.makeText(this, "Angka tidak boleh kurang dari 0", Toast.LENGTH_SHORT).show()
        }
        Log.d("test", "NotifyDecrease $counter --")
    }

    //---
//    fun showCounterValue(value: Int){
//        counterShowBinding.tvCounterSecond.text = value.toString()
//    }
    //---
}