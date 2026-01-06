package com.example.boipata.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    // Logged-in user state
    private val _currentUser = MutableStateFlow<FirebaseUser?>(auth.currentUser)
    val currentUser: StateFlow<FirebaseUser?> = _currentUser

    // Login function
    fun login(email: String, password: String, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        _currentUser.value = auth.currentUser
                        onResult(true)
                    } else {
                        onResult(false)
                    }
                }
        }
    }

    // Register function
    fun register(name: String, email: String, password: String, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Optional: set display name
                        val profileUpdates = com.google.firebase.auth.UserProfileChangeRequest.Builder()
                            .setDisplayName(name)
                            .build()
                        auth.currentUser?.updateProfile(profileUpdates)
                        _currentUser.value = auth.currentUser
                        onResult(true)
                    } else {
                        onResult(false)
                    }
                }
        }
    }

    // Logout function
    fun logout() {
        auth.signOut()
        _currentUser.value = null
    }

    // Check if user is logged in
    fun isUserLoggedIn(): Boolean {
        return auth.currentUser != null
    }
}
