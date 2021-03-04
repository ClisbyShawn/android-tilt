package com.android.shawnclisby.tilt

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.shawnclisby.tilt.data.HaulViewModel
import com.android.shawnclisby.tilt.data.UserViewModel
import com.android.shawnclisby.tilt.data.models.Haul
import com.android.shawnclisby.tilt.databinding.FragmentHaulBinding

class HaulFragment : Fragment(), HaulListAdapter.OnListSelection {

    private var _binding: FragmentHaulBinding? = null
    private val binding get() = _binding!!
    private val haulViewModel: HaulViewModel by activityViewModels()
    private val userViewModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHaulBinding.inflate(inflater, container, false)
        binding.apply {

            //region HAUL RELATED DATA
            val haulAdapter = HaulListAdapter(requireContext(), this@HaulFragment)
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

            //endregion HAUL RELATED DATA

            //region USER RELATED DATA
            userViewModel.user.observe(viewLifecycleOwner) { authUser ->
                authUser?.let { currentUser ->
                    tvHaulUserCompleted.text = currentUser.formatCompletedJobs
                    tvHaulUserEarnings.text = currentUser.formatEarnings
                    tvHaulUserMileage.text = currentUser.formatMilesDriven
                    currentUser.haulId?.let { id ->
                        haulViewModel.hasCurrentHaul(id)
                    }
                }
            }

            //endregion USER RELATED DATA

            //region HAUL AND USER RELATED DATA
            haulViewModel.currentHaul.observe(viewLifecycleOwner) { currentHaulJob ->
                currentHaulJob?.let { haulJob ->
                    containerHaulCurerntJob.visibility = View.VISIBLE
                    viewHaulBottomContainerDivider.visibility = View.VISIBLE
                    tvHaulOriginCity.text = haulJob.carrier.locations.oCity
                    tvHaulDestinationCity.text = haulJob.carrier.locations.dCity
                    tvHaulDay.text = haulJob.formattedCloseDay
                    tvHaulMonth.text = haulJob.formattedCloseMonth
                }
            }

            //endregion HAUL AND USER RELATED DATA

            ivHaulUser.setOnClickListener {
                haulViewModel.newHaulItem()
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onSelected(haul: Haul) {
        haulViewModel.onSelectedHaul(haul)
        findNavController().navigate(R.id.action_haulFragment_to_haulDetailFragment)
    }
}