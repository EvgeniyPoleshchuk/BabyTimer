package com.example.babytimer.dataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.babytimer.dataBase.entity.ProcessBabyEntity
import com.example.babytimer.dataBase.entity.ProcessType
import kotlinx.coroutines.flow.Flow

@Dao
interface ProcessDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveSleep(process: ProcessBabyEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveFood(process: ProcessBabyEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun stopFood(process: ProcessBabyEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun stopSleep(process: ProcessBabyEntity)

    @Query("SELECT * FROM processbaby WHERE type = :processType ORDER BY id DESC LIMIT 1")
    suspend fun getLatestProcess(processType: ProcessType): ProcessBabyEntity?

    @Query("DELETE FROM processbaby WHERE type = :processType")
    suspend fun deleteProcessesByType(processType: ProcessType)

    @Query("SELECT * FROM processbaby")
    fun getAll(): Flow<List<ProcessBabyEntity>>
}