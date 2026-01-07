package com.example.boipata.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.boipata.ui.auth.LoginScreen
import com.example.boipata.ui.auth.RegisterScreen
import com.example.boipata.ui.home.HomeScreen
import com.example.boipata.ui.splash.SplashScreen
import com.example.boipata.viewmodel.AuthViewModel

@Composable
fun BoipataNavGraph(
    navController: NavHostController,
    authViewModel: AuthViewModel
) {
    NavHost(navController = navController, startDestination = Route.SPLASH) {
        composable(Route.SPLASH) { SplashScreen(navController) }
        composable(Route.LOGIN) { LoginScreen(navController, authViewModel) }
        composable(Route.REGISTER) { RegisterScreen(navController, authViewModel) }
        composable(Route.HOME) { HomeScreen() }
    }
}
