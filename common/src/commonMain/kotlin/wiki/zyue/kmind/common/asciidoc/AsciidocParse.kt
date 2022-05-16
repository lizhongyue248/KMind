package wiki.zyue.kmind.common.asciidoc

import androidx.compose.ui.text.TextStyle


enum class AsciidocComponentType {
  /**
   * 文档类型
   */
  DOCUMENT,
  BLOCK,
  CELL,
  COLUMN,
  LIST,
  SECTION,
  LIST_ITEM,
  TABLE,
  NONE
}

data class AsciidocParse(
  val type: AsciidocComponentType,
  var content: String = "",
  var style: TextStyle = TextStyle.Default
)