package com.example.myapplication.data.remote.retrofit

import com.example.myapplication.data.remote.apiservices.CharacterApiService
import com.example.myapplication.data.remote.apiservices.EpisodeApiService
import com.example.myapplication.data.remote.apiservices.LocationApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val okHttpClient: OkHttpClient = OkHttpClient()
        .newBuilder()
        .connectTimeout(40, TimeUnit.SECONDS)
        .readTimeout(40, TimeUnit.SECONDS)
        .writeTimeout(40, TimeUnit.SECONDS)
        .addInterceptor(provideLoggingInterceptor())
        .build()

    private fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    private val provideRetrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    fun provideCharacterApiService(): CharacterApiService =
        provideRetrofit.create(CharacterApiService::class.java)

    fun providesLocationApi(): LocationApiService =
        provideRetrofit.create(LocationApiService::class.java)

    fun providesEpisodesApi(): EpisodeApiService =
        provideRetrofit.create(EpisodeApiService::class.java)
}