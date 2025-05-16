package com.example.evaluacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.room.Room
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
            RecordatorioScreen { nombre, fecha, nivel ->
                insertarRecordatorioDesdeUI(nombre, fecha, nivel)
            }
        }
    }

    @Composable
    fun RecordatorioScreen(onGuardarClick: (String, String, String) -> Unit) {
        val snackbarHostState = remember { SnackbarHostState() }
        val scope = rememberCoroutineScope()

        Scaffold(
            snackbarHost = { SnackbarHost(snackbarHostState) }
        ) { padding ->
            Column(modifier = Modifier.padding(padding).padding(16.dp)) {
                var nombre by remember { mutableStateOf("") }
                var fecha by remember { mutableStateOf("") }
                var nivel by remember { mutableStateOf("") }

                TextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") })
                TextField(value = fecha, onValueChange = { fecha = it }, label = { Text("Fecha") })
                TextField(value = nivel, onValueChange = { nivel = it }, label = { Text("Nivel") })

                Button(onClick = {
                    onGuardarClick(nombre, fecha, nivel)
                    scope.launch {
                        snackbarHostState.showSnackbar("Recordatorio guardado correctamente")
                    }
                }) {
                    Text("Guardar Recordatorio")
                }
            }
        }


    }
    private fun insertarRecordatorioDesdeUI(nombre: String, fecha: String, nivel: String) {
        CoroutineScope(Dispatchers.IO).launch {
            db.recordatorioDao().insert(Recordatorio(0, nombre, fecha, nivel))
        }
    }
}