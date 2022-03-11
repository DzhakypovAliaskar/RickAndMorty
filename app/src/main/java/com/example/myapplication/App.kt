package com.example.myapplication

import android.app.Application
import com.example.myapplication.koin.remoteModule
import com.example.myapplication.koin.repositoriesModel
import com.example.myapplication.koin.viewModelModule
import dagger.hilt.android.HiltAndroidApp
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        GlobalContext.startKoin {
            androidContext(this@App)
            modules(remoteModule, repositoriesModel, viewModelModule)
        }

    }
}