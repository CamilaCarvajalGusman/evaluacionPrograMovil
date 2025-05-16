package com.example.evaluacion.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.Recordatorio
import com.example.usecases.GuardarRecordatorio
import kotlinx.coroutines.launch

class RecordatorioViewModel(private val guardarRecordatorioUseCase: GuardarRecordatorio) : ViewModel() {
    fun guardarRecordatorio(recordatorio: Recordatorio) {
        viewModelScope.launch {
            guardarRecordatorioUseCase.execute(recordatorio)
        }
    }
}