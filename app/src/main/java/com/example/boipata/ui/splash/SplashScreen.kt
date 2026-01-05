package com.example.boipata.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.boipata.R
import com.example.boipata.ui.theme.BoipataTheme
import com.example.boipata.ui.theme.GreenPrimary
import com.example.boipata.ui.theme.GreenSecondary
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {

    // Delay and navigate
    LaunchedEffect(key1 = true) {
        delay(2500L)
        navController.navigate("home") {
            popUpTo("splash") { inclusive = true }
        }
    }

    // Green gradient background
    val greenGradient = Brush.verticalGradient(
        colors = listOf(
            GreenPrimary, // Deep Green
            GreenSecondary  // Light Green
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = greenGradient),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // App Logo from assets/drawable
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

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    BoipataTheme {
        SplashScreen(navController = rememberNavController())
    }
}