package com.onurbalci.hwproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun AnaEkran(navController: NavController) {
    val aracIndexState = remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = aracListesi[aracIndexState.value].resimId),
            contentDescription = null,
            modifier = Modifier.size(200.dp)
        )
        Text(text = "${aracListesi[aracIndexState.value].marka} ${aracListesi[aracIndexState.value].model} (${aracListesi[aracIndexState.value].modelYil})")
        Button(onClick = { navController.navigate("detaylar") }) {
            Text("Detaylar")
        }
    }
}


