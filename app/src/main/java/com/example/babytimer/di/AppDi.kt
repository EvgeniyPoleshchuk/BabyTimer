package com.example.babytimer.di

import androidx.room.Room
import com.example.babytimer.dataBase.AppDataBase
import com.example.babytimer.dataBase.repository.Repository
import org.koin.dsl.module

val repository = module {
    single<Repository> { Repository(get()) }

}
val dataBaseModel = module {
    single {
        Room.databaseBuilder(
            get(),
            AppDataBase::class.java, "process.db"
        ).build()
    }
    single { get<AppDataBase>().processDao() }
}


