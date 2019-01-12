import Emscripten._

import scala.scalanative.native.Ptr

object Hello {
  def main(args: Array[String]): Unit = {
    val delay = 4
    println(s"Hello ${sys.env("USER")} from Scala Native in WebAssembly! Waiting for $delay seconds...") // ${intSqrt(49)}")
    emscripten_async_call(fooFun, null, delay * 1000)
    println("And now for something completely different:")
    Glue.blabla()
  }

//   XXX TODO --- how to make this appear with `-s EXPORTED_FUNCTIONS` ?
//  def intSqrt(x: CInt): CDouble = Math.sqrt(x)

  def foo(arg:Ptr[Byte]):Unit = {
    println("Dang!")
  }

  val fooFun: em_arg_callback_func = { arg: Ptr[_] => foo(arg.asInstanceOf[Ptr[Byte]]) }
}
