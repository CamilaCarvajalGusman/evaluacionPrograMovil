package com.example.framework.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recordatorio")
data class Recordatorio(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Long = 0,

    @ColumnInfo(name = "nombre") val nombre: String,
    @ColumnInfo(name = "fecha") val fecha: String,
    @ColumnInfo(name = "nivel") val nivel: String
)