package com.example.evaluacion.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.domain.Recordatorio
import com.example.evaluacion.viewmodel.RecordatorioViewModel

@Composable
fun RegistroRecordatoriosUI(navController: NavController) {
    val viewModel: RecordatorioViewModel = viewModel()

    var nombre by remember { mutableStateOf("") }
    var fecha by remember { mutableStateOf("") }
    var nivel by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Registra un recordatorio: ",
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            color = Color(0xFF004D40),
            modifier = Modifier.padding(20.dp)
        )
        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre del recordatorio") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = fecha,
            onValueChange = { fecha = it },
            label = { Text("Fecha ") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = nivel,
            onValueChange = { nivel = it },
            label = { Text("Nivel de importancia") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val nuevoRecordatorio = Recordatorio(nombre = nombre, fecha = fecha, nivel = nivel)
                viewModel.guardarRecordatorio(nuevoRecordatorio)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar Recordatorio")
        }
    }
}