package com.example.boipata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.boipata.navigation.BoipataNavGraph
import com.example.boipata.ui.theme.BoipataTheme
import com.example.boipata.viewmodel.AuthViewModel

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

    // Create AuthViewModel instance
    val authViewModel: AuthViewModel = viewModel()

    // Call NavGraph
    BoipataNavGraph(navController = navController, authViewModel = authViewModel)
}