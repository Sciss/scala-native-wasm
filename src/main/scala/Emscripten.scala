import scala.scalanative.native.{CFunctionPtr1, CInt, Ptr, extern}

@extern
object Emscripten {
  // typedef void (*em_arg_callback_func)(void*);

  type em_arg_callback_func = CFunctionPtr1[Ptr[_], Unit]

  def emscripten_async_call(func: em_arg_callback_func, arg: Ptr[_], millis: CInt): Unit = extern
}