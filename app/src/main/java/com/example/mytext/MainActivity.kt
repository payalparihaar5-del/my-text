package com.example.mytext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    FontPreviewScreen()
                }
            }
        }
    }
}

@Composable
fun FontPreviewScreen() {
    var titleText by remember { mutableStateOf("") }

    val fontList = listOf(
        Pair("Default", FontFamily.Default),
        Pair("Serif", FontFamily.Serif),
        Pair("Cursive", FontFamily.Cursive),
        Pair("Monospace", FontFamily.Monospace)

    )

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = titleText,
            onValueChange = { titleText = it },
            label = { Text("Title") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(fontList) { fontItem ->
                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = fontItem.first, fontSize = 12.sp)
                        Text(
                            text = if (titleText.isEmpty()) "Sample Text" else titleText,
                            fontFamily = fontItem.second,
                            fontSize = 24.sp
                        )
                    }
                }
            }
        }
    }
}
