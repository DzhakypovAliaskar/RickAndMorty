package com.example.myapplication.data.remote.apiservices

import com.example.myapplication.data.model.Episod
import com.example.myapplication.data.model.RickAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EpisodeApiService {
    @GET("api/episode")
    suspend fun getEpisode(
        @Query("page") page: Int
    ): RickAndMortyResponse<Episod>


    @GET("api/episode/{id}")
    suspend fun getId(@Path("id") id: Int
    ): Episod

}