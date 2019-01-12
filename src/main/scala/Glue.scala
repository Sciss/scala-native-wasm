import scala.scalanative.native.{CDouble, CFunctionPtr0, CFunctionPtr1, CInt, Ptr, extern}

@extern
object Glue {
  type scala_arg_callback_func = CFunctionPtr1[Ptr[_], Unit]

  type scala_perform_func = CFunctionPtr0[CInt]

  def set_fun_from_scala(f: scala_arg_callback_func): Unit = extern

  def Scala_setOutputBuffer(b: Ptr[CDouble]): Unit = extern

  def Scala_setPerformKsmps(f: scala_perform_func): Unit = extern
}
