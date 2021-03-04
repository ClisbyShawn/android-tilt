package com.android.shawnclisby.tilt

import androidx.recyclerview.widget.RecyclerView
import com.android.shawnclisby.tilt.data.models.Haul
import com.android.shawnclisby.tilt.databinding.ViewHolderHaulBinding

class HaulViewHolder(private val binding: ViewHolderHaulBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(haul: Haul, selection: HaulListAdapter.OnListSelection?) {
        binding.apply {
            tvHolderOrigin.text =
                "${haul.carrier.locations.oCity}, ${haul.carrier.locations.oState}"

            tvHolderDestination.text =
                "${haul.carrier.locations.dCity}, ${haul.carrier.locations.dState}"

            tvHolderPublished.text = haul.formattedPublishDate

            tvHolderWeight.text = haul.carrier.trailer.formattedWeight
            root.setOnClickListener { selection?.onSelected(haul) }
        }
    }
}