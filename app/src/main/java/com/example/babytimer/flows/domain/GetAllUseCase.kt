package com.example.babytimer.flows.domain

import com.example.babytimer.dataBase.entity.ProcessBabyEntity
import com.example.babytimer.dataBase.repository.Repository
import kotlinx.coroutines.flow.Flow

class GetAllUseCase(
    private val processRepository: Repository
) {
    operator fun invoke(): Flow<List<ProcessBabyEntity>> {
        return processRepository.getAll()
    }
}