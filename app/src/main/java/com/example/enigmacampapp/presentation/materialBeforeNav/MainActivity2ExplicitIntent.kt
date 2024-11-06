package com.example.enigmacampapp.presentation.materialBeforeNav

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.enigmacampapp.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity2ExplicitIntent : AppCompatActivity() {

    private lateinit var txtInputName: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_activity2_explicit_intent)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnGreeting: MaterialButton = findViewById(R.id.btn_greeting)
        btnGreeting.setOnClickListener { sendData() }

        txtInputName = findViewById(R.id.txt_input_name)
    }



    private fun sendData() {
        val intent = Intent(this@MainActivity2ExplicitIntent, SecondActivity2::class.java)

        // send data to second activity
        val sendName = txtInputName.text
        txtInputName.text = sendName
        intent.putExtra(SecondActivity2.GET_NAME, txtInputName.text.toString())

        startActivity(intent)
    }

}