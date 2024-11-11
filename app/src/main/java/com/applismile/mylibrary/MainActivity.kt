package com.applismile.mylibrary

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.OptIn
import androidx.camera.core.ExperimentalGetImage
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.applismile.mylibrary.ui.screens.FloatingActionsUi
import com.applismile.mylibrary.ui.theme.MyLibraryTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalGetImage::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyLibraryTheme {
                FloatingActions()
            }
        }
    }
}

@Composable
fun FloatingActions() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionsUi()
        }

    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(modifier = Modifier.fillMaxWidth(), text = "Main Screen")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun FABPreview() {
    MyLibraryTheme {
        FloatingActions()
    }
}