package com.example.enigmacampapp

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var txtInputName: TextInputEditText
    private lateinit var tvHelloName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Log.i("test", "onCreate() initiated moving onStart()")
        // Get a reference to the button view from layout and set a clickListener
        val btnGreeting: MaterialButton = findViewById(R.id.btn_greeting)
        btnGreeting.setOnClickListener {
            Log.i("test", "Button is pressed")
//            updateGreetingMessage()
            getNameFromInput()
        }

//        val txtInputName: TextInputEditText = findViewById(R.id.txt_input_name)
//        val tvHelloName = findViewById<TextView>(R.id.tv_hello_name)

        txtInputName = findViewById(R.id.txt_input_name)
        tvHelloName = findViewById(R.id.tv_hello_name)

//        btnGreeting.setOnClickListener(this)
    }

    // override all method
    override fun onStart() {
        super.onStart()
        Log.i("test", "onStart() initiated moving onResume()")
    }

    override fun onResume() {
        super.onResume()
        Log.i("test", "onResume() waiting for onPause()")
    }

    override fun onPause() {
        super.onPause()
        Log.i("test", "onPause() waiting for onStop() or onResume()")
    }

    override fun onStop() {
        super.onStop()
        Log.i("test", "onStop() waiting for onDestroy() or onRestart()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("test", "onRestart() initiated moving to onStart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("test", "onDestroy() initiated...the app has been killed...")
    }

    // function onClick setting on XML
//    fun btnGreeting(view: View) {
//        val txtInputName: TextInputEditText =
//            findViewById(R.id.txt_input_name)
//        val tvHelloName = findViewById<TextView>(R.id.tv_hello_name)
//
//        // Get the username from editText
//        val getName = txtInputName.text
//
//        // update textView
//        tvHelloName.text = "Hello $getName"
//    }

    // Get a name from an EditText and display a personalized message
    @SuppressLint("SetTextI18n")
    private fun updateGreetingMessage() {
        val txtInputName: TextInputEditText = findViewById(R.id.txt_input_name)
        // val tvHelloName: TextView = findViewById(R.id.tv_hello_name)

        // atau bisa seperti ini
        val tvHelloName = findViewById<TextView>(R.id.tv_hello_name)

        // Get the username from editText
        val getName = txtInputName.text

        // update textView
        tvHelloName.text = "Hello $getName"
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_greeting -> {
                // Get the username from editText
                val getName = txtInputName.text
                // update textView
                tvHelloName.text = "Hello $getName"
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun getNameFromInput() {
        val messageGreeting = listOf<String>("Have nice day", "Never give up", "Keep working hard", "Keep your study")
        val index = (0..4).random()
        val currentMessageGreeting = messageGreeting[index]

        val getName = txtInputName.text
        Log.i("test", "Print getName $getName")
        if (getName.toString() == "") {
            tvHelloName.text = "Make sure to enter your name"
        } else {
            // update textView
            tvHelloName.text = "Hello $getName! $currentMessageGreeting"
        }
        // clear input text with setText
        txtInputName.setText("")
        hideKeyBoard()
    }

    private fun hideKeyBoard() {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(txtInputName.windowToken, 0)
    }

}