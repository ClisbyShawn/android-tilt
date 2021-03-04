package com.android.shawnclisby.tilt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.android.shawnclisby.tilt.data.HaulViewModel
import com.android.shawnclisby.tilt.data.UserViewModel
import com.android.shawnclisby.tilt.databinding.FragmentHaulDetailBinding

class HaulDetailFragment : Fragment() {

    private var _binding: FragmentHaulDetailBinding? = null
    private val binding get() = _binding!!
    private val haulViewModel: HaulViewModel by activityViewModels()
    private val userViewModel: UserViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHaulDetailBinding.inflate(inflater, container, false)
        binding.apply {

            userViewModel.user.observe(viewLifecycleOwner) { authUser ->
                authUser?.let { currentUser ->
                    tvDetailPrompt.text = "${currentUser.firstName} do you accept the job below?"
                }
            }

            haulViewModel.detailHaul.observe(viewLifecycleOwner) { haul ->
                haul?.let {
                    tvDetailOrigin.text =
                        "${it.carrier.locations.oCity}, ${it.carrier.locations.oState}"

                    tvDetailDestination.text =
                        "${it.carrier.locations.dCity}, ${it.carrier.locations.dState}"

                }
            }

            btnDetailTakeJob.setOnClickListener {
                userViewModel.takeHaulJob(haulViewModel.detailHaul.value!!.id)
                findNavController().popBackStack()
            }

        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}