package com.example.babytimer.dataBase

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel<State : Any, Action, Event>(initialState: State) : ViewModel() {
    private val _viewStates = MutableStateFlow(initialState)
    private val _viewAction =
        MutableSharedFlow<Action?>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)

    fun viewStates(): StateFlow<State> = _viewStates.asStateFlow()
    fun viewAction(): SharedFlow<Action?> = _viewAction.asSharedFlow()

    protected var viewState: State
        get() = _viewStates.value
        set(value) {
            _viewStates.value = value
        }

    protected var viewAction: Action?
        get() = _viewAction.replayCache.last()
        set(value) {
            _viewAction.tryEmit(value)
        }

    abstract fun obtainEvent(viewEvent: Event)

    fun clearAction() {
        viewAction = null
    }
}