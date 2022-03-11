package com.example.myapplication.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.myapplication.common.base.BaseRepository
import com.example.myapplication.data.remote.apiservices.CharacterApiService
import com.example.myapplication.data.model.Character
import com.example.myapplication.data.remote.pagingsources.CharacterPagingSources
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val service: CharacterApiService
):BaseRepository() {

    fun fetchCharacter(): LiveData<PagingData<Character>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                prefetchDistance = 2
            ),
            pagingSourceFactory = {
                CharacterPagingSources(service)
            }
        ).liveData
    }
}