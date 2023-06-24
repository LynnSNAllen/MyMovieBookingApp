package com.lynnpadc.moviebookingapp.persistance.typeconverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lynnpadc.moviebookingapp.data.vos.movie.CastVO

class MovieCastTypeConverter {
    @TypeConverter
    fun toString(cast: List<CastVO>?): String{
        return Gson().toJson(cast)
    }

    @TypeConverter
    fun toCastVO(jsonString: String): List<CastVO>?{
        val castType = object : TypeToken<List<CastVO>?>(){}.type
        return Gson().fromJson(jsonString,castType)
    }
}