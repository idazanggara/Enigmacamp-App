package com.example.enigmacampapp.presentation.demo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Calendar
import java.util.TimeZone

class MessageViewModel : ViewModel() {
    private val _message = MutableLiveData<String>()
    val message: LiveData<String> get() = _message


    private val messageQuotes = listOf<String>(
        "Have nice day",
        "Never give up",
        "Keep working hard",
        "Keep your study"
    )
    private val index = (0..3).random()
    private val currentMessageQuote = messageQuotes[index]

    fun sendMessage(name: String) {
        val time = getTimeOfDay()
        _message.value = "Selamat $time $name!! \n $currentMessageQuote"
    }

    private fun getTimeOfDay(): String {
        // Ambil waktu saat ini
        val calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Jakarta"))
        val hour = calendar.get(Calendar.HOUR_OF_DAY)

        // Tentukan string berdasarkan jam saat ini
        return when (hour) {
            in 1..9 -> "Pagi"
            in 10..14 -> "Siang"
            in 15..16 -> "Sore"
            in 17..24, 0 -> "Malam" // termasuk jam 0 untuk memuat tengah malam
            else -> "Waktu tidak diketahui"
        }
    }
}