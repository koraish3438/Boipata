package com.example.boipata.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.boipata.R
import com.example.boipata.ui.theme.GreenPrimary
import com.example.boipata.ui.theme.GreenSecondary
import com.example.boipata.viewmodel.AuthViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController,
    authViewModel: AuthViewModel
) {

    // Check current user and navigate after delay
    LaunchedEffect(key1 = true) {
        delay(2000L) // splash duration
        if (authViewModel.isUserLoggedIn()) {
            navController.navigate("home") {
                popUpTo("splash") { inclusive = true }
            }
        } else {
            navController.navigate("login") {
                popUpTo("splash") { inclusive = true }
            }
        }
    }

    // Green Gradient Background
    val greenGradient = Brush.verticalGradient(
        colors = listOf(GreenPrimary, GreenSecondary)
    )
    
	// Logo + Tagline
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = greenGradient),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.offset(y = (-60).dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Logo
            Image(
                painter = painterResource(id = R.drawable.boipata_logo_),
                contentDescription = "Logo",
                modifier = Modifier.size(160.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))
            
			// Tagline
            Text(
                text = "বই পড়ুন, বই শুনুন – বইপাতায়",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )
        }
    }
}
