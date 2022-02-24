package com.example.myapplication.ui.fragment

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.remote.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {

    fun fetchCharacter(id: Int) = repository.fetchCharacter(id)

}