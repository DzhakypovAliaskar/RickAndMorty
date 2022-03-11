package com.example.myapplication.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.myapplication.common.base.BaseRepository
import com.example.myapplication.data.model.Episod
import com.example.myapplication.data.remote.apiservices.EpisodeApiService
import com.example.myapplication.data.remote.pagingsources.EpisodePagingSource
import javax.inject.Inject

class EpisodeRepository @Inject constructor(
    private val service: EpisodeApiService
) : BaseRepository() {

    fun getEpisodes(): LiveData<PagingData<Episod>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                prefetchDistance = 2
            ),
            pagingSourceFactory = {
                EpisodePagingSource(service)
            }
        ).liveData
    }

}