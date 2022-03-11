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
import com.example.myapplication.databinding.FragmentEpisodesBinding
import com.example.myapplication.ui.adapters.EpisodePagingAdapter
import com.example.myapplication.ui.adapters.paging.CommonLoadStateAdapter
import com.example.myapplication.ui.viewmodel.EpisodeViewModel
import dagger.hilt.android.AndroidEntryPoint

class EpisodesFragment : Fragment(R.layout.fragment_episodes) {
    private val episodesAdapter: EpisodePagingAdapter = EpisodePagingAdapter()
    private val viewModel: EpisodeViewModel by viewModels()
    private lateinit var binding: FragmentEpisodesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEpisodesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRequests()
        setupRecycler()
    }

    private fun setupRequests() = with(binding.recyclerEpisode) {
        adapter = episodesAdapter.withLoadStateFooter(CommonLoadStateAdapter {
            episodesAdapter.retry()
            episodesAdapter.refresh()
        })
        episodesAdapter.addLoadStateListener { loadStates ->
            this.isVisible = loadStates.refresh is LoadState.NotLoading
        }
    }

    private fun setupRecycler() {
        viewModel.getEpisodes().observe(this) {
            lifecycleScope.launchWhenStarted {
                episodesAdapter.submitData(it)
            }
        }
    }
}