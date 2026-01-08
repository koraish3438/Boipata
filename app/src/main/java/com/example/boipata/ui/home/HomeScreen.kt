package com.example.boipata.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.boipata.navigation.Route
import com.google.firebase.auth.FirebaseAuth

data class Book(
    val id: String,
    val title: String,
    val author: String,
    val coverUrl: String
)

@Composable
fun HomeScreen(
    navController: NavController,
    books: List<Book> = sampleBooks()
) {
    val auth = FirebaseAuth.getInstance()

    // If user is null (deleted or not logged in), redirect to login
    if (auth.currentUser == null) {
        navController.navigate(Route.LOGIN) {
            popUpTo(Route.HOME) { inclusive = true }
        }
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDFBF0))
            .padding(16.dp)
    ) {
        // 🔹 Heading
        Text(
            text = "বইপাতা",
            style = MaterialTheme.typography.headlineMedium,
            color = Color(0xFF2C3E50)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 🔹 Book List (takes remaining space)
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(books) { book ->
                BookCard(book)
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // 🔹 Logout Button
        Button(
            onClick = {
                auth.signOut()
                navController.navigate(Route.LOGIN) {
                    popUpTo(Route.HOME) { inclusive = true }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2E7D32)),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                text = "Logout",
                color = Color.White
            )
        }
    }
}

@Composable
fun BookCard(book: Book) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE8F5E9)),
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
    ) {
        Row(modifier = Modifier.padding(12.dp)) {
            Image(
                painter = rememberAsyncImagePainter(book.coverUrl),
                contentDescription = book.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(80.dp)
                    .fillMaxHeight()
                    .background(Color.Gray, RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(book.title, style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(4.dp))
                Text(book.author, style = MaterialTheme.typography.bodyMedium, color = Color.DarkGray)
            }
        }
    }
}

// 🔹 Sample Data
fun sampleBooks() = listOf(
    Book("1", "শীর্ষক ১", "লেখক ১", "https://picsum.photos/200/300"),
    Book("2", "শীর্ষক ২", "লেখক ২", "https://picsum.photos/201/300"),
    Book("3", "শীর্ষক ৩", "লেখক ৩", "https://picsum.photos/202/300"),
    Book("4", "শীর্ষক ৪", "লেখক ৪", "https://picsum.photos/203/300")
)
