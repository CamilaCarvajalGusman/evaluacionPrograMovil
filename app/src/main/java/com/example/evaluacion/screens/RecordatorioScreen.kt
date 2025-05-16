package com.example.evaluacion.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

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
            Text(
                text = "Registra un recordatorio: ",
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp,
                color = Color(0xFF004D40),
                modifier = Modifier.padding(20.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") })
            Spacer(modifier = Modifier.height(8.dp))
            TextField(value = fecha, onValueChange = { fecha = it }, label = { Text("Fecha") })
            Spacer(modifier = Modifier.height(8.dp))
            TextField(value = nivel, onValueChange = { nivel = it }, label = { Text("Nivel") })
            Spacer(modifier = Modifier.height(8.dp))
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
