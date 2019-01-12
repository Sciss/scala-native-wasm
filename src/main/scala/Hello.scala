import Emscripten._

import scala.scalanative.native.Ptr

object Hello {
  def main(args: Array[String]): Unit = {
    val _args: Array[_] = args
    val arg0 = if (_args.isEmpty) null else _args(0) //.asInstanceOf[Any]
    val delay = 4
    println(s"Hello ${sys.env("USER")} from Scala Native in WebAssembly! Waiting for $delay seconds...") // ${intSqrt(49)}")
    println(s"arg0: $arg0")
    emscripten_async_call(foo, null, delay * 1000)
  }

//   XXX TODO --- how to make this appear with `-s EXPORTED_FUNCTIONS` ?
//  def intSqrt(x: CInt): CDouble = Math.sqrt(x)

  def foo: em_arg_callback_func = { _: Ptr[_] =>
    println("Dang!")
  }
}
