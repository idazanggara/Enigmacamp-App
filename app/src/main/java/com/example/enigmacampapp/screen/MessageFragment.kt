package com.example.enigmacampapp.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.enigmacampapp.R
import com.example.enigmacampapp.communicator.MessageController
import com.example.enigmacampapp.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {

    private lateinit var messageController: MessageController
    private lateinit var binding: FragmentMessageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMessageBinding.inflate(inflater, container, false)

        messageController = activity as MessageController

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnGreeting.setOnClickListener {
                val messageGreeting = listOf<String>("Have nice day", "Never give up", "Keep working hard", "Keep your study", "Happy Great Days")
                val index = (0..4).random()
                val currentMessageGreeting = messageGreeting[index]
                val message = "${txtInputName.text.toString()}! $currentMessageGreeting"
                messageController.sendMessage(message)
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = MessageFragment()
    }
}