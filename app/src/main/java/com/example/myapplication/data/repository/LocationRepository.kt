package com.example.myapplication.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.myapplication.common.base.BaseRepository
import com.example.myapplication.data.model.Location
import com.example.myapplication.data.remote.apiservices.LocationApiService
import com.example.myapplication.data.remote.pagingsources.LocationPagingSource
import javax.inject.Inject

class LocationRepository @Inject constructor(
    private val service: LocationApiService
) : BaseRepository(){

    fun getLocations(): LiveData<PagingData<Location>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                prefetchDistance = 2
            ),
            pagingSourceFactory = {
                LocationPagingSource(service)
            }
        ).liveData
    }
}