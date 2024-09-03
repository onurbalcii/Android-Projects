package com.onurbalci.infoproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.onurbalci.infoproject.FootballerRepository.footballerList

@Composable
fun FootballerData(aFootballer: Footballer) {
    Column(modifier = Modifier.padding(16.dp)) {
        Image(
            painterResource(id = aFootballer.imageResource),
            contentDescription = "a footballer",
            contentScale = ContentScale.FillBounds
        )
        Spacer(modifier = Modifier.padding(16.dp))
        Row {
            Column {
                Text(aFootballer.name, color = Color.Black)
                Column {
                    for (ra in aFootballer.resAreas) {
                        Text(text = ra, color = Color.Black)
                    }
                }
            }
            Text(aFootballer.info, color = Color.Black)
        }
    }
}

@Composable
@Preview
fun FootballerDataPreview(){
    FootballerData(footballerList[3]);


}