package com.example.babytimer.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.babytimer.dataBase.converter.Converter
import com.example.babytimer.dataBase.dao.ProcessDao
import com.example.babytimer.dataBase.entity.ProcessBabyEntity

@Database(
    entities = [ProcessBabyEntity::class],
    version = 1,
    )
@TypeConverters(Converter::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun processDao(): ProcessDao

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        // Метод для получения базы данных
        fun getDatabase(context: Context): AppDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "process.db"  // Имя файла базы данных
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}


