package com.example.myapplication.tp4.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.tp4.model.Tp4Room
@Dao
interface Tp4Dao {

    @Query("SELECT * FROM tp4_addre")
    fun selectAll() : LiveData<List<Tp4Room>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(Tp4Room: Tp4Room)


    @Query("DELETE FROM tp4_addre")
    fun deleteAll()
}