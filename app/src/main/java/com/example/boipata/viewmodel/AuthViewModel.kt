package com.example.boipata.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AuthViewModel : ViewModel() {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    // Current logged-in user state
    private val _currentUser = MutableStateFlow<FirebaseUser?>(auth.currentUser)
    val currentUser: StateFlow<FirebaseUser?> = _currentUser

    // ---------------- LOGIN ----------------
    fun login(
        email: String,
        password: String,
        onResult: (Boolean) -> Unit
    ) {
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

    // ---------------- REGISTER ----------------
    fun register(
        name: String,
        email: String,
        password: String,
        onResult: (Boolean) -> Unit
    ) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val profileUpdates = UserProfileChangeRequest.Builder()
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

    // ---------------- LOGOUT ----------------
    fun logout() {
        auth.signOut()
        _currentUser.value = null
    }

    // ---------------- CHECK LOGIN ----------------
    fun isUserLoggedIn(): Boolean {
        return auth.currentUser != null
    }
}
