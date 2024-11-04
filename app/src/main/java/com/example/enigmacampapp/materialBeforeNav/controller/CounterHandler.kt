package com.example.enigmacampapp.materialBeforeNav.controller

interface CounterHandler {
    // tujuan interface untuk antar muka / komunikasi dari fragment ke fragment lain
    // dengan menggunakan interface ini code kita sudah mengunakan OOPnya
    fun notifyShowCounter(counter: Int)
    fun notifyIncrease()
    fun notifyDecrease()
}