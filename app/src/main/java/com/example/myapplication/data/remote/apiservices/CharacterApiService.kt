package com.example.myapplication.data.remote.apiservices

import com.example.myapplication.data.remote.model.Character
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApiService {

    @GET("api/character/{id}")
    suspend fun fetchCharacters(
        @Path("id") id: Int
    ):Character
}