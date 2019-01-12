import Emscripten._

import scala.scalanative.native.Ptr

object Hello {
  def main(args: Array[String]): Unit = {
    println(s"Hello ${sys.env("USER")} from Scala Native in WebAssembly!")
    //    val delay = 4
    //    println(s"Waiting for $delay seconds...") // ${intSqrt(49)}")
//    emscripten_async_call(foo, null, delay * 1000)
    println("And now for something completely different:")
    Glue.set_fun_from_scala(foo)
  }

  val foo: em_arg_callback_func = { _: Ptr[_] =>
    println("Dang!")
  }
}
