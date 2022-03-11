package com.example.myapplication.koin

import com.example.myapplication.data.remote.retrofit.RetrofitClient
import com.example.myapplication.data.repository.CharacterRepository
import com.example.myapplication.data.repository.EpisodeRepository
import com.example.myapplication.data.repository.LocationRepository
import com.example.myapplication.ui.viewmodel.CharacterViewModel
import com.example.myapplication.ui.viewmodel.EpisodeViewModel
import com.example.myapplication.ui.viewmodel.LocationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val remoteModule = module {
    single { RetrofitClient() }
    single { get<RetrofitClient>().provideCharacterApiService() }
    single { get<RetrofitClient>().providesEpisodesApi() }
    single { get<RetrofitClient>().providesLocationApi() }
}
val repositoriesModel = module {
    factory { CharacterRepository(get()) }
    factory { EpisodeRepository(get()) }
    factory { LocationRepository(get()) }
}
val viewModelModule = module {
    viewModel { CharacterViewModel(get()) }
    viewModel { EpisodeViewModel(get()) }
    viewModel { LocationViewModel(get()) }
}
