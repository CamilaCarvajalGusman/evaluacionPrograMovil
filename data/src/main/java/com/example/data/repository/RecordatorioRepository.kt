package com.example.data.repository

import com.example.data.persistence.RecordatorioDAO
import com.example.domain.Recordatorio


class RecordatorioRepository(private val recordatorioDAO: RecordatorioDAO) {
    suspend fun insert(recordatorio: Recordatorio) {
        recordatorioDAO.insert(recordatorio)
    }

    fun getListRecordatorios(): List<Recordatorio> {
        return recordatorioDAO.getRecordatorios()
    }
}