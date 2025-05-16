package com.example.evaluacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.room.Room
import com.example.evaluacion.navigation.AppNavigation
import com.example.framework.persistence.AppRoomDatabase
import com.example.framework.persistence.Recordatorio
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private lateinit var db: AppRoomDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        db = Room.databaseBuilder(
            applicationContext,
            AppRoomDatabase::class.java, "mi_base_de_datos"
        ).build()

        setContent {
            AppNavigation()
        }
    }

    private fun insertarRecordatorioDesdeUI(nombre: String, fecha: String, nivel: String) {
        CoroutineScope(Dispatchers.IO).launch {
            db.recordatorioDao().insert(Recordatorio(0, nombre, fecha, nivel))
        }
    }
}