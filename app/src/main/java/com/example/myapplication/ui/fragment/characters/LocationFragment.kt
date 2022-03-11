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
import com.example.myapplication.databinding.FragmentLocationBinding
import com.example.myapplication.ui.adapters.LocationPagingAdapter
import com.example.myapplication.ui.adapters.paging.CommonLoadStateAdapter
import com.example.myapplication.ui.viewmodel.LocationViewModel
import dagger.hilt.android.AndroidEntryPoint

class LocationFragment : Fragment(R.layout.fragment_location) {

    private val locationAdapter : LocationPagingAdapter = LocationPagingAdapter()
    private lateinit var binding: FragmentLocationBinding
    private val viewModel: LocationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLocationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        setupRequests()
    }

    private fun setupRequests() {
        viewModel.getLocations().observe(this){
            lifecycleScope.launchWhenStarted {
                locationAdapter.submitData(it)
            }
        }
    }

    private fun setupRecycler()  = with(binding.recyclerLocation){
        adapter = locationAdapter.withLoadStateFooter(CommonLoadStateAdapter{
            locationAdapter.retry()
            locationAdapter.refresh()
        })
        locationAdapter.addLoadStateListener { loadStates->
            this.isVisible = loadStates.refresh is LoadState.NotLoading
        }
    }
}