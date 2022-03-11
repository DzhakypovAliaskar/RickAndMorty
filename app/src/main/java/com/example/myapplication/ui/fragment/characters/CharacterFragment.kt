package com.example.myapplication.ui.fragment.characters

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.example.myapplication.R
import com.example.myapplication.common.resource.Resource
import com.example.myapplication.databinding.FragmentCharacterBinding
import com.example.myapplication.ui.adapters.CharacterPagingAdapter
import com.example.myapplication.ui.adapters.paging.CommonLoadStateAdapter
import com.example.myapplication.ui.viewmodel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint

class CharacterFragment : Fragment(R.layout.fragment_character) {

    private lateinit var binding: FragmentCharacterBinding
    private val viewModel: CharacterViewModel by viewModels()
    private val characterAdapter : CharacterPagingAdapter = CharacterPagingAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterBinding.inflate(inflater, container, false)
        binding.recycler.adapter = characterAdapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRequests()
        setupRecycler()
    }

    private fun setupRecycler() = with(binding.recycler) {
        adapter = characterAdapter.withLoadStateFooter(CommonLoadStateAdapter{
            characterAdapter.retry()
            characterAdapter.refresh()
        })
        characterAdapter.addLoadStateListener {loadStates ->
            this.isVisible = loadStates.refresh is LoadState.NotLoading
        }
    }

    private fun setupRequests() {
        viewModel.receiveCharacter().observe(this@CharacterFragment) {
            lifecycleScope.launchWhenStarted {
                characterAdapter.submitData(it)
            }
        }
    }
}