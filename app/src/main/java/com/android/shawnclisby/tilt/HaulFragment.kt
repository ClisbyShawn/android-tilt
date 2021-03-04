package com.android.shawnclisby.tilt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.shawnclisby.tilt.data.HaulViewModel
import com.android.shawnclisby.tilt.databinding.FragmentHaulBinding

class HaulFragment : Fragment() {

    private var _binding: FragmentHaulBinding? = null
    private val binding get() = _binding!!
    private val haulViewModel: HaulViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHaulBinding.inflate(inflater, container, false)
        binding.apply {

            val haulAdapter = HaulListAdapter(requireContext())

            //Pull to Refresh
            refreshHaulNetworkCall.setOnRefreshListener {
                haulViewModel.fetchHaulData()

                refreshHaulNetworkCall.isRefreshing = false
            }

            //RecyclerView
            recyclerHaulList.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = haulAdapter
            }

            haulViewModel.haulList.observe(viewLifecycleOwner) { list ->
                haulAdapter.submitList(list)
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}