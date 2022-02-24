package com.example.myapplication.app

import android.app.Application
import com.example.myapplication.data.remote.RetrofitClient
import com.example.myapplication.data.remote.apiservices.CharacterApiService
import com.example.myapplication.data.remote.repository.CharacterRepository
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
}