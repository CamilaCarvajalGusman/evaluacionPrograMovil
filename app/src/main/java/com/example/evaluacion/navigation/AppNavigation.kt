package com.example.evaluacion.navigation

import RecordatorioViewModel
import SplashScreenContent
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.evaluacion.screens.RegistroRecordatoriosUI
import com.ucb.despensa.navigation.ListaRecordatoriosUI

@Composable
fun AppNavigation(navController: NavHostController, viewModel: RecordatorioViewModel) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None }
    ) {
        composable(Screen.SplashScreen.route) {
            SplashScreenContent(navController)
        }
        composable(Screen.RegistroRecordatorios.route) {
            RegistroRecordatoriosUI(navController, viewModel)
        }
        composable(Screen.ListaRecordatorios.route) {
            ListaRecordatoriosUI(navController)
        }
        composable("registro") { RegistroRecordatoriosUI(navController, viewModel) }
        composable("lista") { ListaRecordatoriosUI(navController) }
    }
}