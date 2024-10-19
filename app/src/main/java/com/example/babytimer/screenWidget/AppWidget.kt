package com.example.babytimer.screenWidget

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.action.ActionParameters
import androidx.glance.action.clickable
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.action.ActionCallback
import androidx.glance.appwidget.action.actionRunCallback
import androidx.glance.appwidget.cornerRadius
import androidx.glance.appwidget.provideContent
import androidx.glance.appwidget.state.updateAppWidgetState
import androidx.glance.background
import androidx.glance.currentState
import androidx.glance.layout.Alignment
import androidx.glance.layout.Box
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.padding
import androidx.glance.layout.size
import androidx.glance.layout.width
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import com.example.babytimer.dataBase.AppDataBase
import com.example.babytimer.dataBase.entity.ProcessBabyEntity
import com.example.babytimer.dataBase.entity.ProcessType
import org.koin.core.component.KoinComponent
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

object AppWidget : GlanceAppWidget(), KoinComponent {

    val isActiveFood = booleanPreferencesKey("activeFood")
    val isActiveSleep = booleanPreferencesKey("activeSleep")

    override suspend fun provideGlance(context: Context, id: GlanceId) {


        provideContent {
            val isActiveFoodState = currentState(isActiveFood) ?: false
            val isActiveSleepState = currentState(isActiveSleep) ?: false


            Column(
                modifier = GlanceModifier
                    .background(Color.DarkGray)
                    .fillMaxSize()
            ) {
                Row(
                    modifier = GlanceModifier.fillMaxSize().padding(10.dp),
                    verticalAlignment = Alignment.Vertical.CenterVertically
                ) {

                    Box(
                        modifier = GlanceModifier
                            .background(if (isActiveFoodState) Color.Red else Color.Green)
                            .size(73.dp)
                            .cornerRadius(10.dp)
                            .clickable(
                                actionRunCallback<SaveFoodActionCallBack>(),
                            ), contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Еда",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                    Spacer(GlanceModifier.width(10.dp))
                    Box(
                        modifier = GlanceModifier
                            .background(if (isActiveSleepState) Color.Red else Color.Green)
                            .size(73.dp)
                            .cornerRadius(10.dp)
                            .clickable(
                                actionRunCallback<SaveSleepActionCallBack>()
                            ), contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Сон",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
            }
        }
    }
}

class SimpleCounterWidgetReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = AppWidget
}

class SaveFoodActionCallBack : ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters,
    ) {

        val repository = AppDataBase.getDatabase(context)
        val time = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.getDefault())
        val formattedTime = time.format(formatter)
        updateAppWidgetState(context, glanceId) { prefs ->
            val currentButtonState = prefs[AppWidget.isActiveFood] ?: false

            val currentProcess = repository.processDao().getLatestProcess(ProcessType.FOOD)
            if (currentProcess == null || currentProcess.timeEnd != "") {
                val newProcess = ProcessBabyEntity(
                    type = ProcessType.FOOD,
                    timeStart = formattedTime
                )
                repository.processDao().saveFood(newProcess)
            } else {
                val updatedProcess = currentProcess.copy(timeEnd = formattedTime)
                repository.processDao().saveFood(updatedProcess)
            }
            prefs[AppWidget.isActiveFood] = !currentButtonState
        }
        AppWidget.update(context, glanceId)
    }
}

class SaveSleepActionCallBack : ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters,
    ) {
        val repository = AppDataBase.getDatabase(context)
        val time = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.getDefault())
        val formattedTime = time.format(formatter)

        updateAppWidgetState(context, glanceId) { prefs ->
            val currentButtonState = prefs[AppWidget.isActiveSleep] ?: false
            val currentProcess = repository.processDao().getLatestProcess(ProcessType.SLEEP)
            if (currentProcess == null || currentProcess.timeEnd != "") {
                val newProcess = ProcessBabyEntity(
                    type = ProcessType.SLEEP,
                    timeStart = formattedTime
                )
                repository.processDao().saveSleep(newProcess)
            } else {
                val updateProcess = currentProcess.copy(timeEnd = formattedTime)
                repository.processDao().saveSleep(updateProcess)
            }
            prefs[AppWidget.isActiveSleep] = !currentButtonState
        }
        AppWidget.update(context, glanceId)
    }
}


