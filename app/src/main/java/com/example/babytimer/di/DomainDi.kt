package com.example.babytimer.di

import com.example.babytimer.flows.domain.DeleteAllUseCase
import com.example.babytimer.flows.domain.GetAllUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetAllUseCase(get()) }
    factory { DeleteAllUseCase(get()) }
}