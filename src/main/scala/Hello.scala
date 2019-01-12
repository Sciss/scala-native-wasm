import Emscripten._

import scala.scalanative.native.Ptr

object Hello {
  def main(args: Array[String]): Unit = {
    val delay = 4
    println(s"Hello ${sys.env("USER")} from Scala Native in WebAssembly! Waiting for $delay seconds...") // ${intSqrt(49)}")
    emscripten_async_call(foo, null, delay * 1000)
  }

//   XXX TODO --- how to make this appear with `-s EXPORTED_FUNCTIONS` ?
//  def intSqrt(x: CInt): CDouble = Math.sqrt(x)

  val foo: em_arg_callback_func = { _: Ptr[_] =>
    println("Dang!")
  }
}
