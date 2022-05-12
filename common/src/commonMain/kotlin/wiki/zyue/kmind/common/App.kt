package wiki.zyue.kmind.common

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*

@Composable
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }

    Button(onClick = {
        text = "Hello, ${getPlatformName()}"
    }) {
        Text(text)
    }
}
