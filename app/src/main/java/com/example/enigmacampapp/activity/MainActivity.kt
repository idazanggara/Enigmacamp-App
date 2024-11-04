package com.example.enigmacampapp.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.enigmacampapp.R
import com.example.enigmacampapp.communicator.MessageController
import com.example.enigmacampapp.screen.MessageFragment
import com.example.enigmacampapp.screen.ShowMessageFragment

class MainActivity : AppCompatActivity(), MessageController {

    companion object {
        const val MESSAGE = "MESSAGE"
    }


    private lateinit var messageFragment: MessageFragment
    private lateinit var messageShowFragment: ShowMessageFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_gretmess)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        messageFragment = MessageFragment()
//        messageShowFragment = ShowMessageFragment()
//
//        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, messageFragment).commit()
    }

//    private fun switchFragment(fragment: Fragment) {
//        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
//    }

    override fun sendMessage(message: String) {
//        val bundle = Bundle()
//        bundle.putString(MESSAGE, message)
//        messageShowFragment.arguments = bundle
//        switchFragment(messageShowFragment)
    }


}