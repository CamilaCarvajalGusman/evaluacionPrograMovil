package com.example.framework.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface IRecordatorioDAO{
    @Query("SELECT * FROM recordatorio")
    fun getList(): List<Recordatorio>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(recordatorio: Recordatorio)


}
