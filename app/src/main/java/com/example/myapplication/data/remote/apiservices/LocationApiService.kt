package com.example.myapplication.data.remote.apiservices

import com.example.myapplication.data.model.Location
import com.example.myapplication.data.model.RickAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface LocationApiService {

    @GET("api/location")
    suspend fun getLocation(
        @Query("page") page: Int
    ): RickAndMortyResponse<Location>

    @GET("api/location/{id}")
    suspend fun getId(@Path("id") id: Int
    ): Location

}