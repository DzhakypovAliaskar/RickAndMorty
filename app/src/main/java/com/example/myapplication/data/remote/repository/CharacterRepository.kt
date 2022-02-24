package com.example.myapplication.data.remote.repository

import android.util.Log
import androidx.lifecycle.liveData
import com.example.myapplication.common.Resource
import com.example.myapplication.data.remote.apiservices.CharacterApiService
import kotlinx.coroutines.Dispatchers
import okhttp3.Dispatcher
import java.lang.Exception
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val service: CharacterApiService
) {
    fun fetchCharacter(id: Int) = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            Log.e("tag", service.fetchCharacters(id).toString())
            emit(Resource.Success(service.fetchCharacters(id)))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Error !", null))
        }
    }
}