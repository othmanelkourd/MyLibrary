package com.applismile.mylibrary.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.applismile.mylibrary.R
import com.applismile.mylibrary.ui.theme.textStyles

@Composable
fun AddBookScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(8.dp)) {
        Text(
            style = textStyles.titleLarge,
            text = "Ajouter un livre"
        )
        BookCover(
            title = "Alchimiste", author = "Paolo coelho"
        )
    }
}

@Composable
fun BookItem() {
    Row(Modifier.padding(6.dp)) {
        AsyncImage(
            model = "https://editions.flammarion.com/media/cache/couverture_medium/flammarion_img/Couvertures/9782081394704.jpg",
            contentDescription = null,
            placeholder = painterResource(id = R.drawable.avatar)
        )

        Column(Modifier.padding(8.dp)) {
            Text(text = "Title", style = textStyles.titleSmall)
            Text(text = "autheur")
        }
    }

}

@Composable
fun BookCover(
    title: String,
    author: String,
) {
    Card(
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.avatar),
                contentDescription = "Book Cover",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = author,
                style = MaterialTheme.typography.titleSmall
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun BookItemPreview() {
    BookCover(title = "Alchimiste", author = "Paolo coelho")
}

@Composable
@Preview(showBackground = true)
fun AddBookPreview() {
    AddBookScreen()
}