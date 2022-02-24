package com.example.myapplication.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.data.remote.model.Character
import com.example.myapplication.databinding.ItemCharacterBinding

class CharacterAdapter: RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    private var list: ArrayList<Character> = ArrayList()

    fun addList(list: ArrayList<Character>?) {
        if (list != null) {
            this.list = list
        }
        notifyDataSetChanged()
    }

//    fun addList(list: Character?) {
//        if (list != null) {
//            this.list.add(list)
//        }
//        notifyDataSetChanged()
//    }

    class ViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(character: Character) {
            binding.tvName.text = character.name
            binding.tvStatus.text = character.status
            Glide.with(binding.ivCharacter).load(character.image).into(binding.ivCharacter)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}