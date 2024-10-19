package com.example.babytimer.app

import android.app.Application

import com.example.babytimer.di.appModule
import com.example.babytimer.di.dataBaseModel
import com.example.babytimer.di.domainModule
import com.example.babytimer.di.repository
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BabyTimerApp:Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BabyTimerApp)
            modules(modules = listOf(domainModule, repository, appModule, dataBaseModel))
        }
    }
}