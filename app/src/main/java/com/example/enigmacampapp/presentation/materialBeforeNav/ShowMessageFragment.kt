package com.example.enigmacampapp.presentation.materialBeforeNav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.enigmacampapp.R
import com.example.enigmacampapp.databinding.FragmentShowMessageBinding
import com.example.enigmacampapp.presentation.auth.screen.MessageFragment

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
//        getMessage = arguments?.getString(MainBeforeNavActivity.MESSAGE)
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