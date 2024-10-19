package com.example.babytimer.flows.domain

import com.example.babytimer.dataBase.entity.ProcessType
import com.example.babytimer.dataBase.repository.Repository

class DeleteAllUseCase(
    private val processRepository: Repository
) {
    suspend operator fun invoke(type: ProcessType) {
        return processRepository.deleteAll(type)
    }

}