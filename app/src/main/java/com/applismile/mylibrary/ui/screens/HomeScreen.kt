package com.applismile.mylibrary.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.applismile.mylibrary.BookViewModel
import com.applismile.mylibrary.api.BookInfoResponse
import com.applismile.mylibrary.api.NetWorkResult
import com.applismile.mylibrary.ui.theme.textStyles


@Composable
fun HomePage(
    booksViewModel: BookViewModel = hiltViewModel()
) {

    val bookInfo = booksViewModel.response.collectAsState()

    val result: NetWorkResult<BookInfoResponse> = bookInfo.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Text(
            text = "Ma bibliothèque",
            style = textStyles.titleLarge,
            modifier = Modifier.padding(8.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = result.data?.totalItems.toString(),
            style = textStyles.bodyMedium,
            textAlign = TextAlign.Center
        )
    }
}


@Composable
fun HomeTitle() {
    Text(text = "Ma bibliothèque", style = textStyles.titleLarge)
}


@Preview
@Composable
fun HomePagePreview() {
    HomePage()
}