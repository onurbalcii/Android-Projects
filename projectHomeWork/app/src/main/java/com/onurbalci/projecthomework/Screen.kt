package com.erdem.projecthomework

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController




enum class Screens{
    FirstS, SecondS, ThirdS, FourthS
}


@Composable
fun GameScreen(navCont: NavHostController = rememberNavController()){
    NavHost(navController = navCont, startDestination = Screens.FirstS.name){
        composable(route = Screens.FirstS.name){
            GameCard(Games[0], onNextClicked = {
                navCont.navigate(Screens.SecondS.name)
            })
        }
        composable(route=Screens.SecondS.name) {
            GameCard(Games[1], onNextClicked = {
                navCont.navigate((Screens.ThirdS.name))
            })
        }
        composable(route = Screens.ThirdS.name){
            GameCard(Games[2], onNextClicked = {
                navCont.navigate(Screens.FourthS.name)
            })
        }
        composable(route = Screens.FourthS.name){
            GameCard(Games[3], onNextClicked = {
                navCont.navigate(Screens.FirstS.name)
            })
        }
    }
}


@Composable
fun GameCard(Games: Game, onNextClicked:()->Unit){
    Column(){
        Image(painterResource(Games.imageResource),"RDR2")
        Row (modifier = Modifier){
            Column(){
                Text(text = Games.name);
                Text(text = Games.gameType);
            }
            Text(text = Games.info)
        }
        Button(onClick = { onNextClicked()}){
            Text("Next")
        }
    }
}