package com.example.myapplication.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.common.Resource
import com.example.myapplication.data.remote.model.Character
import com.example.myapplication.databinding.FragmentCharacterBinding
import com.example.myapplication.ui.adapters.CharacterAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterFragment : Fragment() {

    private lateinit var binding: FragmentCharacterBinding
    private lateinit var viewModel: CharacterViewModel
    private val characterAdapter: CharacterAdapter = CharacterAdapter()
    private val list: ArrayList<Character> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        getData()
    }

    private fun getData() {
        viewModel.fetchCharacter(1).observe(viewLifecycleOwner, {
            when (it) {
                is Resource.Error -> {

                }
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    characterAdapter.addList(it.data)
                }
            }
        })
    }

    private fun initialize() {
        viewModel = ViewModelProvider(this)[CharacterViewModel::class.java]
        binding.recycler.adapter = characterAdapter
    }
}