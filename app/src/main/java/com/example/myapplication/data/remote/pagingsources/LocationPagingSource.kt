package com.example.myapplication.data.remote.pagingsources

import com.example.myapplication.common.base.BasePagingSource
import com.example.myapplication.data.model.Location
import com.example.myapplication.data.remote.apiservices.LocationApiService

class LocationPagingSource(
    private val serviceLocationApi: LocationApiService
) : BasePagingSource<Location, Any?>({ position ->
    serviceLocationApi.getLocation(position)
})