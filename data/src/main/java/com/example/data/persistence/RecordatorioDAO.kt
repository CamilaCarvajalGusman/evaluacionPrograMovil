package com.example.data.persistence

import com.example.domain.Recordatorio
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface RecordatorioDAO {
    @Query("SELECT * FROM recordatorio")
    fun getRecordatorios(): List<Recordatorio>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(recordatorio: Recordatorio)

}