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
import wiki.zyue.kmind.common.asciidoc.AsciidocParse
import wiki.zyue.kmind.common.asciidoc.AsciidoctorK.asciidoctor
import wiki.zyue.kmind.common.asciidoc.AsciidoctorK.options


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
        val result = asciidoctor.convert(value.text, options, AsciidocParse::class.java)
        println("value change ========${result.content}")
      }
    )

  }

  LaunchedEffect(Unit) {
    focusRequester.requestFocus()
  }

}
