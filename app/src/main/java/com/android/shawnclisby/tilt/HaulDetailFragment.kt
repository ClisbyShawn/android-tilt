package com.android.shawnclisby.tilt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.android.shawnclisby.tilt.data.HaulViewModel
import com.android.shawnclisby.tilt.databinding.FragmentHaulDetailBinding

class HaulDetailFragment : Fragment() {

    private var _binding: FragmentHaulDetailBinding? = null
    private val binding get() = _binding!!
    private val haulViewModel: HaulViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHaulDetailBinding.inflate(inflater, container, false)
        binding.apply {


        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}