package com.example.babytimer.dataBase.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProcessBabyEntity(

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo
    var type: ProcessType = ProcessType.FOOD,

    @ColumnInfo(name = "time_start")
    var timeStart:String = "",

    @ColumnInfo(name = "time_end")
    var timeEnd:String = "",

    @ColumnInfo
    var description:String = ""
)
enum class ProcessType() {
    FOOD, SLEEP
}