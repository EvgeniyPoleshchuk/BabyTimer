package com.example.babytimer.flows.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.babytimer.dataBase.entity.ProcessBabyEntity
import com.example.babytimer.dataBase.entity.ProcessType
import com.example.babytimer.flows.components.MainViewTimeCard
import com.example.babytimer.flows.presentation.model.MainViewEvent
import com.example.babytimer.flows.presentation.model.MainViewState
import com.example.babytimer.flows.presentation.model.tabList
import com.example.babytimer.ui.theme.VerticalGap


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainView(
    viewState: MainViewState,
    onEvent: (MainViewEvent) -> Unit
) {

    val pagerState = rememberPagerState {
        tabList.size
    }
    LaunchedEffect(viewState.currentPage) {
        pagerState.animateScrollToPage(viewState.currentPage)
    }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress) {
            onEvent.invoke(MainViewEvent.IndexRow(pagerState.currentPage))
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.systemBars.asPaddingValues())
    ) {
        TabRow(selectedTabIndex = viewState.currentPage) {
            tabList.forEachIndexed { index, item ->
                Tab(selected = index == viewState.currentPage, onClick = {
                    onEvent.invoke(MainViewEvent.IndexRow(index))
                    onEvent.invoke(MainViewEvent.GetALLData)
                },
                    text = {
                        Text(text = item.title)
                    },
                    icon = {
                        Icon(
                            imageVector = if (index == viewState.currentPage) {
                                ImageVector.vectorResource(id = item.selectedIcon)
                            } else ImageVector.vectorResource(id = item.unSelectedIcon),
                            contentDescription = item.title
                        )
                    }
                )

            }
        }
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
        ) { index ->
            when (index) {
                0 -> {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
                        VerticalGap(size = 10)
                        ItemList(process = viewState.processList.filter { type -> type.type == ProcessType.FOOD })
                        DeleteButton {
                            onEvent(MainViewEvent.DeleteData(ProcessType.FOOD))
                        }
                    }

                }
                1 -> {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
                        VerticalGap(size = 10)
                        ItemList(process = viewState.processList.filter { type -> type.type == ProcessType.SLEEP })
                        DeleteButton {
                            onEvent(MainViewEvent.DeleteData(ProcessType.SLEEP))
                        }
                    }

                }
            }
        }


    }
}

@Composable
fun DeleteButton(function: () -> Unit) = Box(
    modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.BottomEnd
) {
    FloatingActionButton(
        onClick = { function() },
        containerColor = Color.Red,
        modifier = Modifier.padding(end = 10.dp)
    ) {
        Icon(imageVector = Icons.Default.Delete, contentDescription = "")

    }
}


@Composable
fun ItemList(process: List<ProcessBabyEntity>) {
    LazyColumn {
        items(process) { process ->
            VerticalGap(size = 10)
            MainViewTimeCard(timeStart = process.timeStart, timeEnd = process.timeEnd)

        }
    }
}


