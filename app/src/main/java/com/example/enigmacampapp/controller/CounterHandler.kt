package com.example.enigmacampapp.controller

interface CounterHandler {
    // tujuan interface untuk antar muka / komunikasi dari fragment ke fragment lain
    // dengan menggunakan interface ini code kita sudah mengunakan OOPnya
    fun notifyShowCounter(counter: Int)
//    fun notifIncres()
//    fun notifDecres()
}