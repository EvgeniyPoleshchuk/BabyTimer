package com.example.babytimer.flows.presentation.model

import com.example.babytimer.dataBase.entity.ProcessType

sealed class MainViewEvent {
    data object GetALLData : MainViewEvent()
    data class DeleteData(val type: ProcessType) : MainViewEvent()
    data class IndexRow(val index: Int) : MainViewEvent()
}