package com.example.enigmacampapp.presentation.home.screen

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.enigmacampapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Ambil data dari arguments
//        val message = arguments?.getString(HomeActivity.MESSAGE)
//        if (message != null) {
//            // Tampilkan data di TextView atau view lain
//            binding.tvFullName.text = message
//        }
        // Passing Data With Safe Args
//        val args = HomeFragmentArgs.fromBundle(requireArguments())
//        binding.tvFullName.text = args.passedMessage
        binding.tvFullName.text = "Idaz Anggara"

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = HomeFragment()
    }
}