package com.example.boipata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.boipata.navigation.BoipataNavGraph
import com.example.boipata.ui.theme.BoipataTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BoipataTheme {
                BoipataApp()
            }
        }
    }
}

@Composable
fun BoipataApp() {
    // NavController for navigation
    val navController = rememberNavController()

    // Call NavGraph
    BoipataNavGraph(navController = navController)
}