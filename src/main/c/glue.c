#include <stdio.h>
#include "glue.h"

scala_arg_callback_func scala_func_var;

void set_fun_from_scala(scala_arg_callback_func f) {
  printf("Hello from C glue code!\n");
  scala_func_var = f;
  return;
}

void call_scala_func() {
  scala_func_var(0);
  return;
}