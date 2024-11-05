package com.example.enigmacampapp.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.enigmacampapp.R
import com.example.enigmacampapp.activity.HomeActivity
import com.example.enigmacampapp.communicator.MessageController
import com.example.enigmacampapp.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {

//    private lateinit var messageController: MessageController
    private lateinit var binding: FragmentMessageBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        binding.apply {
            btnGreeting.setOnClickListener {
                sendMessage()
            }
        }
    }
    private fun sendMessage() {
//        val bundle = bundleOf(HomeActivity.MESSAGE to binding.teFullName.text.toString())
//        navController.navigate(R.id.action_global_homeFragment, bundle)
        // Passing Data With Safe Args
        navController.navigate(MessageFragmentDirections.actionMessageFragmentToHomeFragment(binding.teFullName.text.toString()))

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = MessageFragment()
    }
}

//  Before Nested Navigation
//class MessageFragment : Fragment() {
//
//    //    private lateinit var messageController: MessageController
//    private lateinit var binding: FragmentMessageBinding
//    private lateinit var navController: NavController
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        binding = FragmentMessageBinding.inflate(inflater, container, false)
////        messageController = activity as MessageController
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        navController = Navigation.findNavController(view)
//        binding.apply {
//            btnGreeting.setOnClickListener {
////                val messageGreeting = listOf<String>("Have nice day", "Never give up", "Keep working hard", "Keep your study", "Happy Great Days")
////                val index = (0..4).random()
////                val currentMessageGreeting = messageGreeting[index]
////                val message = "${txtInputName.text.toString()}! $currentMessageGreeting"
////                messageController.sendMessage(message)
//                sendMessage()
//            }
//        }
//    }
//    private fun sendMessage() {
//        val bundle = bundleOf(HomeActivity.MESSAGE to binding.teFullName.text.toString())
//        navController.navigate(R.id.action_messageFragment_to_homeActivity, bundle)
//    }
//
//    companion object {
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) = MessageFragment()
//    }
//}