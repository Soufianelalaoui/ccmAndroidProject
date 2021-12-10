package com.example.myapplication.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.tp4.dao.Tp4Dao
import com.example.myapplication.tp4.model.Tp4Room

@Database(
    entities = [
        Tp4Room::class
    ],
    version = 1,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {
    abstract fun tp4Dao() : Tp4Dao
}

