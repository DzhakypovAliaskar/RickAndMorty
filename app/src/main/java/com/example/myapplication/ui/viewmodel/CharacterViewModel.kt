package com.example.myapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.myapplication.data.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class CharacterViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {

    fun receiveCharacter() = repository.fetchCharacter().cachedIn(viewModelScope)
}