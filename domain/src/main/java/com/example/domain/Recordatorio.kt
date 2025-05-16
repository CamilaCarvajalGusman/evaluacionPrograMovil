package com.example.domain
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recordatorio")
data class Recordatorio(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val nombre: String,
    val fecha: String,  // Ahora es String
    val nivel: String
)