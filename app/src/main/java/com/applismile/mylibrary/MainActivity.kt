package com.applismile.mylibrary

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.OptIn
import androidx.camera.core.ExperimentalGetImage
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.applismile.mylibrary.ui.theme.MyLibraryTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalGetImage::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyLibraryTheme {
                Greeting(
                    action = {
                        val intent = Intent(this, ScannerActivity::class.java)
                        startActivity(intent)
                    }
                )
            }
        }
    }
}

@Composable
fun Greeting(action: () -> Unit) {
    Button(
        modifier = Modifier.padding(30.dp),
        onClick = action
    ) {
        Text(text = "scan")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyLibraryTheme {
        Greeting() {}
    }
}