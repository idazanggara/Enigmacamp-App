package com.example.enigmacampapp.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.enigmacampapp.R
import com.example.enigmacampapp.databinding.FragmentGreetingBinding


class GreetingFragment : Fragment() {

    private lateinit var binding: FragmentGreetingBinding
    private lateinit var fragmentMessage: MessageFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGreetingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentMessage = MessageFragment()
        binding.btnStart.setOnClickListener {
            findNavController().navigate(R.id.action_greetingFragment_to_messageFragment)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = GreetingFragment()
    }
}