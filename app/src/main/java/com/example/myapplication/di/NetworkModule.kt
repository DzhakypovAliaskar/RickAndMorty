package com.example.myapplication.di

import com.example.myapplication.data.remote.RetrofitClient
import com.example.myapplication.data.remote.apiservices.CharacterApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    private val retrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun provideCharacterApiService(): CharacterApiService = retrofitClient
        .provideCharacterApiService()
}