package com.onurbalci.hwproject

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun DetaylarEkrani(aracIndexState: MutableState<Int>, navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Detaylar Ekranı")
        Button(onClick = {
            if (aracIndexState.value < aracListesi.size - 1) {
                aracIndexState.value++
            } else {
                aracIndexState.value = 0
            }
            navController.popBackStack()
        }) {
            Text("Geri Dön")
        }
    }
}
