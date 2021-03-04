package com.android.shawnclisby.tilt

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.android.shawnclisby.tilt.data.models.Haul
import com.android.shawnclisby.tilt.databinding.ViewHolderHaulBinding

class HaulListAdapter(private val context: Context, private val onSelected: OnListSelection?) :
    ListAdapter<Haul, HaulViewHolder>(object :
        DiffUtil.ItemCallback<Haul>() {
        override fun areItemsTheSame(oldItem: Haul, newItem: Haul): Boolean {
            return oldItem.publishedDate == newItem.publishedDate
        }

        override fun areContentsTheSame(oldItem: Haul, newItem: Haul): Boolean {
            return oldItem == newItem
        }
    }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HaulViewHolder {
        return HaulViewHolder(
            ViewHolderHaulBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HaulViewHolder, position: Int) {
        holder.onBind(getItem(position), onSelected)
    }

    interface OnListSelection {
        fun onSelected(haul: Haul)
    }
}