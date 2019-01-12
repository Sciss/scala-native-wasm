import scala.scalanative.native.{CDouble, CInt}

object Hello {
  def main(args: Array[String]): Unit = {
    println(s"Hello ${sys.env("USER")} from Scala Native in WebAssembly! ${intSqrt(49)}")
  }

  // XXX TODO --- how to make this appear with `-s EXPORTED_FUNCTIONS` ?
  def intSqrt(x: CInt): CDouble = Math.sqrt(x)
}
