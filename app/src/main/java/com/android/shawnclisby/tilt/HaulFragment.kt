package com.android.shawnclisby.tilt

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.shawnclisby.tilt.data.HaulViewModel
import com.android.shawnclisby.tilt.data.models.Haul
import com.android.shawnclisby.tilt.databinding.FragmentHaulBinding

class HaulFragment : Fragment(), HaulListAdapter.OnListSelection {

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

            val haulAdapter = HaulListAdapter(requireContext(),this@HaulFragment)

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

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setHasOptionsMenu(true)
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.haul_menu, menu)
//        super.onCreateOptionsMenu(menu, inflater)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when (item.itemId) {
//            R.id.action_new_haul -> {
//                haulViewModel.newHaulItem()
//                true
//            }
//
//            else -> super.onOptionsItemSelected(item)
//        }
//    }

    override fun onSelected(haul: Haul) {
        haulViewModel.onSelectedHaul(haul)
        findNavController().navigate(R.id.action_haulFragment_to_haulDetailFragment)
    }
}