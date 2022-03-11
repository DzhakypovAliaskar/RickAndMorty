package com.example.myapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.myapplication.data.repository.EpisodeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(
    private val episodeRepository: EpisodeRepository
) : ViewModel() {

    fun getEpisode(page: Int) = episodeRepository.getEpisode(page)

    fun getEpisodes() = episodeRepository.getEpisodes().cachedIn(viewModelScope)

}