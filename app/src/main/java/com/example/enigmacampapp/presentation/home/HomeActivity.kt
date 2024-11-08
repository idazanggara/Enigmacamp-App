package com.example.enigmacampapp.presentation.home

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.enigmacampapp.R
import com.example.enigmacampapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    companion object {
        const val MESSAGE = "MESSAGE"
    }
    private lateinit var binding: ActivityHomeBinding
    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment

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
//        val message = intent.extras?.getString(MESSAGE)
//        if (message != null) {
//            // Menampilkan data ke dalam view (misalnya TextView)
//            binding.tvFullName.text = message
//        }

        binding.apply {
            navHostFragment = supportFragmentManager.findFragmentById(navHostHome.id) as NavHostFragment
            navController = navHostFragment.findNavController()
            NavigationUI.setupWithNavController(bottomNavigationView, navController)
        }
    }
}