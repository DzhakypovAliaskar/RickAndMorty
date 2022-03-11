package com.example.myapplication.data.remote.pagingsources

import com.example.myapplication.common.base.BasePagingSource
import com.example.myapplication.data.model.Character
import com.example.myapplication.data.remote.apiservices.CharacterApiService

class CharacterPagingSources(
    private val serviceCharacterApi: CharacterApiService
) : BasePagingSource<Character, Any?>({ position ->
    serviceCharacterApi.fetchCharacters(position)
})
