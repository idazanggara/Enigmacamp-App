package com.example.enigmacampapp.presentation.materialBeforeNav

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.enigmacampapp.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity3ImplicitIntent : AppCompatActivity(), View.OnClickListener {

    private lateinit var txtInputPlayer1: TextInputEditText
    private lateinit var txtInputPlayer2: TextInputEditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_activity3_implicit_intent)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnPlay: MaterialButton = findViewById(R.id.btn_play)
        btnPlay.setOnClickListener(this)

        txtInputPlayer1 = findViewById(R.id.txt_input_player_1)
        txtInputPlayer2 = findViewById(R.id.txt_input_player_2)


    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_play -> setIntent(txtInputPlayer1.text.toString())
        }
    }

    private fun setIntent(typeOfIntent: String = "explicit") {
        when(typeOfIntent) {
            "explicit" -> {
                val intent = Intent(this@MainActivity3ImplicitIntent, SecondActivity3::class.java)
                val playerOne = txtInputPlayer1.text.toString()
                val playerTwo = txtInputPlayer2.text.toString()
                intent.putExtra(SecondActivity3.PLAYER_ONE, playerOne)
                intent.putExtra(SecondActivity3.PLAYER_TWO, playerTwo)
                startActivity(intent)
            }
            "implicit" -> {
                val imp = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.enigmacamp.com/"))
                startActivity(imp)
            }
        }
    }
}