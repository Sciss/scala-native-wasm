import scala.scalanative.native.{CFunctionPtr1, Ptr, extern}

@extern
object Glue {
  type scala_arg_callback_func = CFunctionPtr1[Ptr[_], Unit]

  def set_fun_from_scala(f: scala_arg_callback_func): Unit = extern
}
