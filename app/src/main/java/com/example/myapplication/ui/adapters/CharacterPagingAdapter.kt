package com.example.myapplication.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.common.base.BaseDiffUtilItemCallback
import com.example.myapplication.data.model.Character
import com.example.myapplication.databinding.ItemCharacterBinding

class CharacterPagingAdapter(
) : PagingDataAdapter<Character, CharacterPagingAdapter.CharacterViewHolder>(
    BaseDiffUtilItemCallback()
) {

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    inner class CharacterViewHolder(
        private val binding: ItemCharacterBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: Character) {
            binding.tvName.text = item.name
            binding.tvStatus.text = item.status
            Glide.with(binding.ivCharacter).load(item.image).into(binding.ivCharacter)
        }
    }
}