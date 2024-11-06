package com.example.enigmacampapp.presentation.demo.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.enigmacampapp.R
import com.example.enigmacampapp.databinding.FragmentBlockVolumeBinding
import com.example.enigmacampapp.presentation.communicator.BlockVolumeCommunicator

class BlockVolumeFragment : Fragment() {

    private lateinit var binding: FragmentBlockVolumeBinding
    private lateinit var blockVolumeCommunicator: BlockVolumeCommunicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        blockVolumeCommunicator = activity as BlockVolumeCommunicator
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBlockVolumeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCalculate.setOnClickListener {
            blockVolumeCommunicator.calculate()
        }
    }

    fun calculateBlockVolume(): Double {
        val length = binding.blockLength.text.toString()
        val width = binding.blockWidth.text.toString()
        val height = binding.blockHeight.text.toString()
        return length.toDouble() * width.toDouble() * height.toDouble()
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) = BlockVolumeFragment()
    }
}