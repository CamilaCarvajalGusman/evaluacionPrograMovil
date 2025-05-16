package com.example.evaluacion.screens

import RecordatorioViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.domain.Recordatorio
import java.util.Date

@Composable
fun RegistroRecordatoriosUI(navController: NavController, viewModel: RecordatorioViewModel) {
    var nombre by remember { mutableStateOf("") }
    var nivel by remember { mutableStateOf("") }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Registrar un Recordatorio", fontSize = 30.sp, fontWeight = FontWeight.Bold)

        TextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") })
        TextField(value = nivel, onValueChange = { nivel = it }, label = { Text("Nivel") })

        OutlinedButton(
            onClick = {
                val nuevoRecordatorio = Recordatorio(nombre = nombre, fecha = Date(), nivel = nivel)
                viewModel.guardarRecordatorio(nuevoRecordatorio)
            }
        ) {
            Text("Guardar")
        }
    }
}