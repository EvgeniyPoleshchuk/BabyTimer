package com.example.babytimer.dataBase.repository

import com.example.babytimer.dataBase.entity.ProcessBabyEntity
import com.example.babytimer.dataBase.dao.ProcessDao
import com.example.babytimer.dataBase.entity.ProcessType
import kotlinx.coroutines.flow.Flow

class Repository(private val processDao: ProcessDao) {

    suspend fun addFood(process: ProcessBabyEntity) {
        processDao.saveFood(process)
    }

    suspend fun addSleep(process: ProcessBabyEntity) {
        processDao.saveSleep(process)
    }

    suspend fun stopFood(process: ProcessBabyEntity) {
        processDao.stopFood(process)
    }

    suspend fun stopSleep(process: ProcessBabyEntity) {
        processDao.stopSleep(process)
    }

    suspend fun deleteAll(type: ProcessType) {
        processDao.deleteProcessesByType(type)
    }

    fun getAll(): Flow<List<ProcessBabyEntity>> = processDao.getAll()
}