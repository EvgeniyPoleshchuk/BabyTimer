package com.example.babytimer.di

import com.example.babytimer.flows.presentation.MainViewModel
import org.koin.dsl.module

val appModule = module {
    single { MainViewModel(get(),get()) }
}