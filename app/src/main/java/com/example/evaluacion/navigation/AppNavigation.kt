package com.example.evaluacion.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.evaluacion.screens.RecordatorioScreen
import com.example.evaluacion.screens.RegistroRecordatoriosUI
import com.example.evaluacion.screens.SplashScreen
import com.ucb.despensa.navigation.ListaRecordatoriosUI

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    //val recordatorioViewModel: RecordatorioViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None }
    ) {
        composable(Screen.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(Screen.RegistroRecordatorios.route) {
            RegistroRecordatoriosUI(navController)
        }
        composable(Screen.ListaRecordatorios.route) {
            ListaRecordatoriosUI(navController)
        }
        composable("registro") {
            RegistroRecordatoriosUI(navController)
        }
        composable("lista") {
            ListaRecordatoriosUI(navController)
        }
        composable("recordatorio_screen") {
            RecordatorioScreen { nombre, fecha, nivel ->
                navController.navigate(Screen.ListaRecordatorios.route)
            }
        }
    }
}