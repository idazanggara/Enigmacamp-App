package com.example.enigmacampapp.presentation.materialBeforeNav

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.enigmacampapp.R
import com.google.android.material.button.MaterialButton

class CounterAppAnI02 : AppCompatActivity() {

    private lateinit var count: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_counter_app_an_i02)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnIncrement: MaterialButton = findViewById(R.id.btn_increment)
        val btnDecrement: MaterialButton = findViewById(R.id.btn_decrement)
        btnIncrement.setOnClickListener { increment() }
        btnDecrement.setOnClickListener { decrement() }
        count = findViewById(R.id.tv_number_count)
    }

    private fun increment() {
        val currentNumber = count.text.toString().toInt()
        count.text = (currentNumber + 1).toString()
    }

    private fun decrement() {
        val currentNumber = count.text.toString().toInt()
        count.text = (currentNumber - 1).toString()
    }
}