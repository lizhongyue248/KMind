package wiki.zyue.kmind.common.asciidoc

import org.asciidoctor.Asciidoctor
import org.asciidoctor.Options
import org.asciidoctor.ast.*
import org.asciidoctor.converter.AbstractConverter
import org.asciidoctor.converter.ConverterFor
import java.io.OutputStream
import java.nio.charset.Charset

internal const val COMPONENT_BACKEND = "component"

abstract class ComposableConverter(backend: String, opts: Map<String, Any>) :
  AbstractConverter<AsciidocParse>(backend, opts) {
  override fun write(output: AsciidocParse?, out: OutputStream) {
    if (output != null) {
      out.write(output.toString().toByteArray(Charset.forName("UTF-8")))
    }
  }
}


@ConverterFor(COMPONENT_BACKEND)
class ComponentConverter(backend: String, opts: Map<String, Any>) : ComposableConverter(backend, opts) {
  override fun convert(node: ContentNode, transform: String?, opts: MutableMap<Any, Any>?): AsciidocParse {
    val asciidocParse = when (node) {
      is Document -> AsciidocParse(AsciidocComponentType.DOCUMENT)
      is Block -> AsciidocParse(AsciidocComponentType.BLOCK)
      is Cell -> AsciidocParse(AsciidocComponentType.CELL)
      is Column -> AsciidocParse(AsciidocComponentType.COLUMN)
      is org.asciidoctor.ast.List -> AsciidocParse(AsciidocComponentType.LIST)
      is Section -> AsciidocParse(AsciidocComponentType.SECTION)
      is ListItem -> AsciidocParse(AsciidocComponentType.LIST_ITEM)
      is Table -> AsciidocParse(AsciidocComponentType.TABLE)
      else -> AsciidocParse(AsciidocComponentType.NONE)
    }
    asciidocParse.content = node.context
    return asciidocParse
  }

}

object AsciidoctorK {

  val asciidoctor: Asciidoctor = Asciidoctor.Factory.create()

  val options: Options = Options.builder().backend(COMPONENT_BACKEND).build()

  init {
    asciidoctor.javaConverterRegistry().register(ComponentConverter::class.java, COMPONENT_BACKEND)
  }

}