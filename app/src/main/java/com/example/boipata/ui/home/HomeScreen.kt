package com.example.boipata.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

data class Book(
    val id: String,
    val title: String,
    val author: String,
    val coverUrl: String
)

@Composable
fun HomeScreen(
    books: List<Book> = sampleBooks()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDFBF0)) // soft paper background
            .padding(16.dp)
    ) {
        Text(
            text = "বইপাতা - Home",
            style = MaterialTheme.typography.headlineMedium,
            color = Color(0xFF2C3E50)
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(books) { book ->
                BookCard(book)
            }
        }
    }
}

@Composable
fun BookCard(book: Book) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFE8F5E9) // light green card
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
    ) {
        Row(
            modifier = Modifier.padding(12.dp)
        ) {
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

// Sample books for preview
fun sampleBooks() = listOf(
    Book("1", "শীর্ষক ১", "লেখক ১", "https://picsum.photos/200/300"),
    Book("2", "শীর্ষক ২", "লেখক ২", "https://picsum.photos/201/300"),
    Book("3", "শীর্ষক ৩", "লেখক ৩", "https://picsum.photos/202/300"),
    Book("4", "শীর্ষক ৪", "লেখক ৪", "https://picsum.photos/203/300")
)

