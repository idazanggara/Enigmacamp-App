package com.example.enigmacampapp.presentation.demo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.enigmacampapp.R
import com.example.enigmacampapp.databinding.ActivityTheCounterBinding
import com.example.enigmacampapp.presentation.demo.screen.CounterFragment
import com.example.enigmacampapp.presentation.demo.screen.CounterShowFragment

class TheCounterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTheCounterBinding
    private lateinit var fragmentCounter: CounterFragment
    private lateinit var fragmentCounterShow: CounterShowFragment
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTheCounterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        fragmentCounter = CounterFragment()
        fragmentCounterShow = CounterShowFragment()
        binding.apply {
            supportFragmentManager.beginTransaction().add(binding.counterFragment.id, fragmentCounter).commit()
            supportFragmentManager.beginTransaction().add(binding.counterShowFragment.id, fragmentCounterShow).commit()
        }
    }
}