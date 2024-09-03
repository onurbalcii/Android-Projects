package com.onurbalci.hwproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeapp.ui.theme.ComposeAppTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeApp()
        }
    }
}

@Composable
fun ComposeApp() {
    ComposeAppTheme {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "araclar") {
            composable("araclar") {
                AnaEkran(navController)
            }
        }
    }
}


