package wiki.zyue.kmind.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.Dp

@Composable
fun App() {
  val textFieldValueState = remember {
    mutableStateOf(
      TextFieldValue(text = "Hello")
    )
  }
  val focusRequester = remember { FocusRequester() }
  Column {
    BasicTextField(
      modifier = Modifier.fillMaxWidth()
        .fillMaxHeight()
        .focusRequester(focusRequester)
        .padding(Dp(5F)),
      value = textFieldValueState.value,
      onValueChange = { value ->
        textFieldValueState.value = value
        println(value.text)
      }
    )
  }

  LaunchedEffect(Unit) {
    focusRequester.requestFocus()
  }

}
