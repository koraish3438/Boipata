package com.example.boipata.ui.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.boipata.ui.theme.BoipataTheme
import com.example.boipata.viewmodel.AuthViewModel

@Composable
fun LoginScreen(
    navController: NavController,
    authViewModel: AuthViewModel
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var emailError by remember { mutableStateOf<String?>(null) }
    var passError by remember { mutableStateOf<String?>(null) }

    fun validate(): Boolean {
        emailError = if (!email.contains("@")) "সঠিক ইমেইল দিন" else null
        passError = if (password.length < 6) "পাসওয়ার্ড কমপক্ষে ৬ ডিজিট" else null
        return emailError == null && passError == null
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text("Login", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            isError = emailError != null
        )
        emailError?.let { Text(it, color = MaterialTheme.colorScheme.error) }

        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            isError = passError != null
        )
        passError?.let { Text(it, color = MaterialTheme.colorScheme.error) }

        Spacer(Modifier.height(16.dp))

        Button(onClick = {
            if (validate()) {
                authViewModel.login(email, password) { success ->
                    if (success) navController.navigate("home") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            }
        }, Modifier.fillMaxWidth()) {
            Text("Login")
        }

        Spacer(Modifier.height(12.dp))

        TextButton(onClick = { navController.navigate("register") }) {
            Text("Don't have an account? Create account")
        }

        TextButton(onClick = { navController.navigate("home") }) {
            Text("Continue without account")
        }
    }
}
