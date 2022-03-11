package com.example.myapplication.data.remote.pagingsources

import com.example.myapplication.common.base.BasePagingSource
import com.example.myapplication.data.model.Episod
import com.example.myapplication.data.remote.apiservices.EpisodeApiService

class EpisodePagingSource(
    private val servicesEpisodeApi: EpisodeApiService
) : BasePagingSource<Episod, Any?>({ position ->
    servicesEpisodeApi.getEpisode(position)
})