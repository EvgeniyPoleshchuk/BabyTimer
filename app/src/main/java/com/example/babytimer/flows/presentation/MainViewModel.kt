package com.example.babytimer.flows.presentation

import androidx.lifecycle.viewModelScope
import com.example.babytimer.dataBase.BaseViewModel
import com.example.babytimer.dataBase.entity.ProcessType
import com.example.babytimer.flows.domain.DeleteAllUseCase
import com.example.babytimer.flows.domain.GetAllUseCase
import com.example.babytimer.flows.presentation.model.MainViewAction
import com.example.babytimer.flows.presentation.model.MainViewEvent
import com.example.babytimer.flows.presentation.model.MainViewState
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class MainViewModel(
    private val getAllUseCase: GetAllUseCase,
    private val deleteAllUseCase: DeleteAllUseCase
) :
    BaseViewModel<MainViewState, MainViewAction, MainViewEvent>(MainViewState()),
    KoinComponent {
    init {
        observeData()
    }

    override fun obtainEvent(viewEvent: MainViewEvent) {
        when (viewEvent) {
            is MainViewEvent.GetALLData -> observeData()
            is MainViewEvent.IndexRow -> pagerIndex(viewEvent.index)
            is MainViewEvent.DeleteData -> deleteAll(type = viewEvent.type)
        }
    }

    private fun observeData() {
        viewModelScope.launch {
            getAllUseCase.invoke().collect { process ->
                viewState = viewState.copy(processList = process)
            }
        }
    }

    private fun pagerIndex(index: Int) {
        viewState = viewState.copy(currentPage = index)
    }

    private fun deleteAll(type: ProcessType) {
        viewModelScope.launch {
            deleteAllUseCase(type)
        }
    }


}