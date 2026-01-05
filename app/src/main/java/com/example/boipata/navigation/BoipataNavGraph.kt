package com.example.boipata.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.boipata.ui.splash.SplashScreen
//import com.example.boipata.ui.auth.LoginScreen
//import com.example.boipata.ui.auth.RegisterScreen
//import com.example.boipata.ui.home.HomeScreen


@Composable
fun BoipataNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {
        // Splash Screen
        composable("splash") {
            SplashScreen(navController)
        }

//        // Login Screen
//        composable("login") {
//            LoginScreen(navController)
//        }
//
//        // Register Screen
//        composable("register") {
//            RegisterScreen(navController)
//        }
//
//        // Home Screen
//        composable("home") {
//            HomeScreen()
//        }
    }
}