package com.applismile.mylibrary

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.OptIn
import androidx.camera.core.ExperimentalGetImage
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Create
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.applismile.mylibrary.ui.CustomExpandableFAB
import com.applismile.mylibrary.ui.FABItem
import com.applismile.mylibrary.ui.screens.HomePage
import com.applismile.mylibrary.ui.theme.MyLibraryTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalGetImage::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyLibraryTheme {
               HomePage()
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
    val context = LocalContext.current

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {

            val itemList = listOf(
                FABItem(icon = Icons.Rounded.Call, text = "Call"),
                FABItem(icon = Icons.Rounded.Create, text = "Create"),
                FABItem(icon = Icons.Rounded.AccountCircle, text = "Account"),
            )

            CustomExpandableFAB(
                items = itemList,
                onItemClick = {item ->

                    when(item.text) {
                        "Call" -> Toast.makeText(context, "call clicked", Toast.LENGTH_SHORT).show()
                        "Create" -> Toast.makeText(context, "create clicked", Toast.LENGTH_SHORT).show()
                        "Account" -> Toast.makeText(context, "account clicked", Toast.LENGTH_SHORT).show()
                    }

                }
            )
        }

    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {

        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyLibraryTheme {
        Greeting("ma biblio")
    }
}