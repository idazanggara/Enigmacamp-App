package com.example.enigmacampapp.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.enigmacampapp.R
import com.example.enigmacampapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    companion object {
        const val MESSAGE = "MESSAGE"
    }
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding =  ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Mendapatkan data dari Bundle
        val message = intent.extras?.getString(MESSAGE)
        if (message != null) {
            // Menampilkan data ke dalam view (misalnya TextView)
            binding.tvFullName.text = message
        }
    }
}