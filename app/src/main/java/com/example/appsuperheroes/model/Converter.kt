package com.example.appsuperheroes.model

import androidx.room.TypeConverter

class Converter {

    @TypeConverter
    fun listToString(list: List<String>): String {
        return list.joinToString()
    }
    @TypeConverter
    fun stringToList(value: String): List<String> {
        return value.split(",").map {
            it.trim()
        }
    }

    @TypeConverter
    fun listToDouble(list: List<Double>): String {
        return list.joinToString()
    }

    @TypeConverter
    fun doublesToList(value: String): List<Double> {
        val result = mutableListOf<Double>()
        value.split(",").forEach {
            if (it.isNotEmpty()) {
                result.add(it.trim().toDouble())
            }
        }
        return result
    }
}