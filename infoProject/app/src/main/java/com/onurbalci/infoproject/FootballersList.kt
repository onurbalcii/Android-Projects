package com.onurbalci.infoproject

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.onurbalci.infoproject.FootballerRepository.footballerList

@Composable
fun FootballersList(flist: List<Footballer>) {
    LazyColumn {
        items(flist) { aFoot ->
            FootballerData(aFoot)
        }
    }
}

@Composable
@Preview
fun FootballersListPreview(){
    FootballersList(footballerList)
}