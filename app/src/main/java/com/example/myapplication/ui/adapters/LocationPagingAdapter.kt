package com.example.myapplication.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.common.base.BaseDiffUtilItemCallback
import com.example.myapplication.data.model.Location
import com.example.myapplication.databinding.ItemLocationBinding

class LocationPagingAdapter(
) : PagingDataAdapter<Location, LocationPagingAdapter.LocationViewHolder>(
    BaseDiffUtilItemCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        return LocationViewHolder(
            ItemLocationBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class LocationViewHolder(
        private val binding: ItemLocationBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: Location) {
            binding.namePerson.text = item.name
            binding.number.text = item.type
        }
    }

}