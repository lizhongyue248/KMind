import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import wiki.zyue.kmind.common.App
import wiki.zyue.kmind.common.ui.theme.MindTheme

fun main() = application {
  Window(onCloseRequest = ::exitApplication) {
    MindTheme {
      App()
    }
  }
}
