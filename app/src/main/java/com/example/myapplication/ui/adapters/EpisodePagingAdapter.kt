package com.example.myapplication.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.common.base.BaseDiffUtilItemCallback
import com.example.myapplication.data.model.Episod
import com.example.myapplication.databinding.ItemEpisodesBinding

class EpisodePagingAdapter(
) : PagingDataAdapter<Episod, EpisodePagingAdapter.EpisodesViewHolder>(
    BaseDiffUtilItemCallback()
){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodesViewHolder {
        return EpisodesViewHolder(
            ItemEpisodesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: EpisodesViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class EpisodesViewHolder(
        private val binding: ItemEpisodesBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun onBind(item: Episod) {
            binding.namePerson.text = item.name
            binding.number.text = item.episodes
        }
    }
}