package com.example.myapplication.data.remote.apiservices

import com.example.myapplication.data.remote.model.Character
import com.example.myapplication.data.remote.model.response.RickAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApiService {

    @GET("api/character/{id}")
    suspend fun fetchCharacterId(
        @Path("id") id: Int
    ):Character

    @GET("api/character")
   suspend fun fetchCharacters(
        @Query("page") page:Int
    ): RickAndMortyResponse<Character>
}