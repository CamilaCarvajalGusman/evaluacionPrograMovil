package com.example.evaluacion.book

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BookUI(){
    var text by remember { mutableStateOf("Esto es la prueba de un texto UI 1")}
    Box(
        modifier = Modifier.fillMaxSize()
            .padding(10.dp).background(Color.Magenta),
        contentAlignment = Alignment.Center
    ){
        Column(horizontalAlignment = Alignment.CenterHorizontally
        ){
            TextField(
                modifier = Modifier.fillMaxWidth().background(Color.Transparent),
                value = text,

                onValueChange={}
            )
        }
    }
}