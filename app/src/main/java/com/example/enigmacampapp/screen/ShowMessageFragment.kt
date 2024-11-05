package com.example.enigmacampapp.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.example.enigmacampapp.R
import com.example.enigmacampapp.activity.MainActivity
import com.example.enigmacampapp.databinding.FragmentShowMessageBinding

class ShowMessageFragment : Fragment() {

    private lateinit var binding: FragmentShowMessageBinding
    private var getMessage: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentShowMessageBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        getMessage = arguments?.getString(MainActivity.MESSAGE)
        binding.apply {
            tvHelloName.text = getMessage
            btnBack.setOnClickListener {
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, MessageFragment())
                    .commit()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = ShowMessageFragment()
    }
}