package com.example.usecases

import com.example.domain.ILocalDataSource
import com.example.domain.Recordatorio

class GuardarRecordatorio(private val localDataSource: ILocalDataSource) {
    fun execute(recordatorio: Recordatorio): Boolean {
        return localDataSource.save(recordatorio)
    }
}

