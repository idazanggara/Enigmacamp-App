package com.example.enigmacampapp.presentation.counter

import android.util.Log
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    var counter = 0
    fun notifyIncrease() {
        counter++
        Log.i("test", "notifyIncrease: $counter")
    }
}