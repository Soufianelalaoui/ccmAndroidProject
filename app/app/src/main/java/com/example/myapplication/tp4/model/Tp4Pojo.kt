package com.example.myapplication.tp4.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/** Object use for room */
@Entity(tableName = "tp4_addre")
data class Tp4Room(
    @ColumnInfo(name = "full_address")
    val full_address: String,


    @ColumnInfo(name = "city")
    val city: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}


data class Tp4Ui(
    val full_address: String,
    val city: String
)

/** Object use for retrofit */
data class Tp4Retrofit(
    @Expose
    @SerializedName("full_address")
    val full_address: String,


    @Expose
    @SerializedName("city")
    val city: String
)

