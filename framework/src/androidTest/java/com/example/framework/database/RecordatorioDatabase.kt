package com.example.framework.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.domain.model.Recordatorio
import com.example.domain.RecordatorioDao

@Database(entities = [Recordatorio::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class RecordatorioDatabase : RoomDatabase() {
    abstract fun recordatorioDao(): RecordatorioDao

    companion object {
        @Volatile
        private var INSTANCE: RecordatorioDatabase? = null

        fun getDatabase(context: Context): RecordatorioDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RecordatorioDatabase::class.java,
                    "recordatorio_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}