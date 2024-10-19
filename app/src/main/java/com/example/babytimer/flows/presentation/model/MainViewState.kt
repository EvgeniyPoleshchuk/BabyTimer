package com.example.babytimer.flows.presentation.model

import com.example.babytimer.dataBase.entity.ProcessBabyEntity

data class MainViewState(
    val currentPage: Int = 0,
    val isStart: Boolean = false,
    val processList: List<ProcessBabyEntity> = emptyList(),
)