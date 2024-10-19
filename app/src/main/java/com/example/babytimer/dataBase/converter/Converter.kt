package com.example.babytimer.dataBase.converter

import androidx.room.TypeConverter
import com.example.babytimer.dataBase.entity.ProcessType

class Converter {

    @TypeConverter
    fun fromType(type: ProcessType): String {
        return type.name
    }

    @TypeConverter
    fun toType(value: String): ProcessType {
        return ProcessType.valueOf(value)
    }
}