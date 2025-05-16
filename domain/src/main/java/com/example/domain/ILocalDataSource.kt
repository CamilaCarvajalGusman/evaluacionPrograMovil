package com.example.domain

interface ILocalDataSource {
    fun save(recordatorio: Recordatorio): Boolean

}