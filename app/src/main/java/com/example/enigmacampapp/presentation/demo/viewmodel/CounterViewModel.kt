package com.example.enigmacampapp.presentation.demo.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    var counter = MutableLiveData(0)
    private var cnt = 0

    fun notifyIncrease() {
        cnt++
        counter.value = cnt
        Log.i("test", "notifyIncrease: ${counter.value}")
    }

    fun notifyDecrease() {
        cnt--
        counter.value = cnt
        Log.i("test", "notifyDecrease: ${counter.value}")
    }
}