package com.example.evaluacion.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
data class RegistrarRecordatorioUI(
    val nombre: String,
    val fecha: String,
    val nivel: String
)
@Composable
fun ListaRecordatoriosUI(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFFB2EBF2), Color(0xFFE0F7FA))
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            // Título centrado
            Text(
                text = "Lista",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF004D40),
                modifier = Modifier.padding(20.dp)
            )

            // Lista de recordatorios
            val recordatorios = listOf(
                RegistrarRecordatorioUI("Estudiar Cálculo", "2025-06-01", "Muy Importante"),
                RegistrarRecordatorioUI("Estudiar Cálculo", "2025-06-01", "Muy Importante"),
            )

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                recordatorios.forEach { recordatorio ->
                    Text(
                        text = "Nombre: ${recordatorio.nombre} | Fecha: ${recordatorio.fecha} | Nivel: ${recordatorio.nivel}",
                        fontSize = 18.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }

            // Botón abajo centrado
            OutlinedButton(
                onClick = {
                    navController.navigate("recordatorio_screen")
                },
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color(0xFF00796B),
                    contentColor = Color.White
                ),
                modifier = Modifier.padding(20.dp)
            ) {
                Text("Registrar nuevo", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}