package com.example.babytimer.flows

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.example.babytimer.flows.presentation.MainViewModel
import com.example.babytimer.flows.presentation.model.MainViewEvent
import com.example.babytimer.flows.ui.MainView
import org.koin.compose.koinInject

class MainScreen(innerPaddingValues: PaddingValues) {
    @Composable
    fun Content() {
        val viewModel: MainViewModel = koinInject<MainViewModel>()
        val viewState by viewModel.viewStates().collectAsState()

        val lifecycleOwner = LocalLifecycleOwner.current
        DisposableEffect(lifecycleOwner) {
            val observer = LifecycleEventObserver { _: LifecycleOwner, event: Lifecycle.Event ->
                when (event) {
                    Lifecycle.Event.ON_RESUME -> {
                        // Когда приложение вернулось в активное состояние, обновляем данные
                        viewModel.obtainEvent(MainViewEvent.GetALLData)
                    }
                    else -> {}
                }
            }

            // Добавляем наблюдателя
            lifecycleOwner.lifecycle.addObserver(observer)

            // Убираем наблюдателя при завершении
            onDispose {
                lifecycleOwner.lifecycle.removeObserver(observer)
            }
        }


        MainView(viewState = viewState) { event ->
            viewModel.obtainEvent(event)

        }
    }
}