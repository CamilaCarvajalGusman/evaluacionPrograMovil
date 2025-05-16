package com.example.evaluacion.navigation

sealed class Screen(val route: String) {
    object SplashScreen : Screen("inicio")
    object RegistroRecordatorios : Screen("registro")
    object ListaRecordatorios : Screen("lista")
}