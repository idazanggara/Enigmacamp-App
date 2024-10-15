package com.example.enigmacampapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class SecondActivity2 : AppCompatActivity() {
    companion object {
        const val GET_NAME = "get_name"
    }

    private lateinit var tvHelloName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvHelloName = findViewById(R.id.tv_hello_name)

        // get value form intent with key from GET_NAME
        val getName = intent.getStringExtra(GET_NAME)
        // set value to text view in second activity
        tvHelloName.text = getName

        // button back to main activity
        val btnBack: MaterialButton = findViewById(R.id.btn_back)
        btnBack.setOnClickListener { backButton() }

    }

    private fun backButton() {
        finish()
    }
}