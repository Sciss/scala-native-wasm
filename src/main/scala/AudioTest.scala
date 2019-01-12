import scala.scalanative.native
import scala.scalanative.native.{CDouble, CInt, Ptr}
import scala.scalanative.runtime.libc

object AudioTest {
  private[this] var buf: Ptr[CDouble] = _

  private[this] final val blockSize = 64

  def main(args: Array[String]): Unit = {
    println("Hello from Scala Native in WebAssembly!")
//    Glue.set_fun_from_scala(foo)
    buf = libc.malloc(native.sizeof[CDouble] * blockSize).asInstanceOf[Ptr[CDouble]]
    Glue.Scala_setOutputBuffer(buf)
    Glue.Scala_setPerformKsmps(perform _)
  }

  private[this] val rnd = new util.Random

  private def perform(): CInt = {
    val b = buf
    val r = rnd
    var i = 0
    while (i < blockSize) {
      b(i) = r.nextDouble() - 0.5
      i += 1
    }
    0
  }

//  val foo: em_arg_callback_func = { _: Ptr[_] =>
//    println("Dang!")
//  }
}
