package com.example.enigmacampapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.enigmacampapp.databinding.ActivityMainForFrgmntBinding

class MainForFrgmntActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainForFrgmntBinding
    private lateinit var fragmentCounter: Counter01Fragment
    private lateinit var fragmentCounterShow: CounterShow01Fragment
    private var counter: Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_main_for_frgmnt)
        binding = ActivityMainForFrgmntBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        fragmentCounter = Counter01Fragment()
        fragmentCounterShow = CounterShow01Fragment()
        binding.apply {
//            supportFragmentManager.beginTransaction().add(fragmentCounter.id, fragmentCounter).commit()
//            supportFragmentManager.beginTransaction().add(fragmentCounterShow.id, fragmentCounterShow).commit()

            supportFragmentManager.beginTransaction().add(R.id.counter_fragment, fragmentCounter).commit()
            supportFragmentManager.beginTransaction().add(R.id.counter_show_fragment, fragmentCounterShow).commit()

        }
    }

    fun notifyIncrease(){
        counter++
        Log.d("test", "NotifyIncrease $counter ++")
        fragmentCounterShow.notifyShowCounter(counter)
    }

    fun notifyDecrease(){
        if (counter > 0){
            counter--
            fragmentCounterShow.notifyShowCounter(counter)
        } else {
            Toast.makeText(this, "Angka tidak boleh kurang dari 0", Toast.LENGTH_SHORT).show()
        }
        Log.d("test", "NotifyDecrease $counter --")
    }
}