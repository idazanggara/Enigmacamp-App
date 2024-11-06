package com.example.enigmacampapp.presentation.demo.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.enigmacampapp.R
import com.example.enigmacampapp.databinding.FragmentBlockVolumeShowBinding

class BlockVolumeShowFragment : Fragment() {

    private lateinit var binding: FragmentBlockVolumeShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBlockVolumeShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun getCalculateBlockVolume(result: Double) {
        binding.tvBlockShowVolume.text = result.toString()
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = BlockVolumeShowFragment()
    }
}