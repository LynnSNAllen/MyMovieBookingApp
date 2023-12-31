package com.lynnpadc.moviebookingapp.persistance.typeconverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SafetyTypeConverter {
    @TypeConverter
    fun toString(safetyList: List<String>?): String{
        return Gson().toJson(safetyList)
    }

    @TypeConverter
    fun toSafetyVO(jsonString: String): List<String>?{
        val safetyType = object : TypeToken<List<String>?>(){}.type
        return Gson().fromJson(jsonString,safetyType)
    }
}