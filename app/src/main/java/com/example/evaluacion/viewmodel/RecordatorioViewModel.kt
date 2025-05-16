package com.example.evaluacion.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.framework.persistence.AppRoomDatabase
import com.example.framework.persistence.Recordatorio
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecordatorioViewModel(private val database: AppRoomDatabase) : ViewModel() {

    fun insertarRecordatorio(recordatorio: Recordatorio) {
        viewModelScope.launch(Dispatchers.IO) {
            database.recordatorioDao().insert(recordatorio)
        }
    }

    fun obtenerRecordatorios(): List<Recordatorio> {
        return database.recordatorioDao().getList()
    }
}