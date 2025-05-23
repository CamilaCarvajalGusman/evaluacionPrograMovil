package com.example.framework.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Recordatorio::class], version = 1)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun recordatorioDao(): IRecordatorioDAO


    companion object {
        @Volatile
        private var Instance: AppRoomDatabase? = null

        fun getDatabase(context: Context): AppRoomDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, AppRoomDatabase::class.java, "item_database")
                    .build()
                    .also { Instance = it }
            }
        }


    }
}

