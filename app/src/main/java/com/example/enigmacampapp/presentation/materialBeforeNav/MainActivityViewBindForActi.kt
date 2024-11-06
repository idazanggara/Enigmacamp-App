package com.example.enigmacampapp.presentation.materialBeforeNav

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.Gravity
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.enigmacampapp.R
import com.example.enigmacampapp.databinding.ActivityMainViewBindForBinding

class MainActivityViewBindForActi : AppCompatActivity() {

//    private lateinit var txtInputName: TextInputEditText
//    private lateinit var tvHelloName: TextView
    private lateinit var binding: ActivityMainViewBindForBinding

    private lateinit var cameraLauncher: ActivityResultLauncher<Uri>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ngambil layoutnya
        binding = ActivityMainViewBindForBinding.inflate(layoutInflater)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_main_view_bind_for)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        txtInputName = findViewById(R.id.txt_input_name)
//        tvHelloName = findViewById(R.id.tv_hello_name)
//        val btnGreeting: MaterialButton = findViewById(R.id.btn_greeting)
        binding.txtInputName
        binding.tvHelloName
        binding.btnGreeting
//        binding.btnGreeting.setOnClickListener {
//            getNameFromInput()
//        }

        cameraLauncher = registerForActivityResult(ActivityResultContracts.TakePicture()) {
                isSuccess ->
            if (isSuccess) {
                // Foto berhasil diambil, handle foto di sini, uri yang digunakan adalah yang sama yang dikirimkan saat memulai
                val toast = Toast.makeText(this,"Berhasil Take a Picture", Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER, 0, 0)  // Posisikan di tengah layar
                toast.show()
            } else {
                // Handle jika pengambilan gambar gagal
                val toast = Toast.makeText(this,"Gagal Take a Picture", Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER, 0, 0)  // Posisikan di tengah layar
                toast.show()
            }
        }

        binding.apply {
            btnGreeting.setOnClickListener {
                getNameFromInput()
            }

            btnOpenBrowser.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://www.google.com")
                startActivity(intent)
            }

            btnOpenCamera.setOnClickListener {
                Log.i("TEST", "onCreate: test intent")
//
                val photoUri = createImageUri() // Buat URI untuk file gambar
                cameraLauncher.launch(photoUri)
            }

        }


    }
    private fun createImageUri(): Uri {
        val contentResolver = contentResolver
        val contentValues = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, "new_photo.jpg")
            put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
        }
        return contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)!!
    }

    @SuppressLint("SetTextI18n")
    private fun getNameFromInput() {
        val messageGreeting = listOf<String>("Have nice day", "Never give up", "Keep working hard", "Keep your study")
        val index = (0..4).random()
        val currentMessageGreeting = messageGreeting[index]

//        val getName = txtInputName.text
        val getName = binding.txtInputName.text
        Log.i("test", "Print getName $getName")
        if (getName.toString() == "") {
//            tvHelloName.text = "Make sure to enter your name"
            binding.tvHelloName.text = "Make sure to enter your name"
        } else {
            // update textView
//            tvHelloName.text = "Hello $getName! $currentMessageGreeting"
            binding.tvHelloName.text = "Hello $getName! $currentMessageGreeting"
        }
        // clear input text with setText
//        txtInputName.setText("")
            binding.txtInputName.setText("")
        hideKeyBoard()
    }

    private fun hideKeyBoard() {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        inputMethodManager.hideSoftInputFromWindow(txtInputName.windowToken, 0)
        inputMethodManager.hideSoftInputFromWindow(binding.txtInputName.windowToken, 0)
    }
}