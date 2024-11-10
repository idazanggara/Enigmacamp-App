package com.example.enigmacampapp.presentation.counter

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.enigmacampapp.R
import com.example.enigmacampapp.databinding.ActivityCounterBinding

class CounterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCounterBinding
    private lateinit var counterViewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCounterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. Cara yang salah dan kurang tepat ketika init view model
        //counterViewModel = CounterViewModel()

        // 2. ViewModelProviders
        counterViewModel = ViewModelProvider(this)[CounterViewModel::class.java]
        binding.apply {
            tvCounter.text = counterViewModel.counter.toString()
            btnIncrement.setOnClickListener {
                counterViewModel.notifyIncrease()
                tvCounter.text = counterViewModel.counter.toString()
            }
        }

        /**
         * ViewModels
         * 1. ViewModel scope -> dia tidak memiliki sebuah data persintance
         * 2. ViewModel -> tidak boleh memiliki referensi langsung terhadap UI (activity, fragment dll)
         * 3. Penghubung bisa menggunakan Application Context, Livedata (kita pakai ini)
         * 4. Livedata -> observable
         * 5. View -> dia akan mesubscribe apa yang di sediakan oleh si livedata
         */
    }
}