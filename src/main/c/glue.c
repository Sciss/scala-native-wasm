#include <stdio.h>
#include "glue.h"

scala_arg_callback_func scala_func_var;
double* output_buffer;
scala_perform_func scala_perform_var;

void set_fun_from_scala(scala_arg_callback_func f) {
  printf("Hello from C glue code!\n");
  scala_func_var = f;
  return;
}

void Scala_setPerformKsmps(scala_perform_func f) {
  printf("Hello from C glue code!\n");
    scala_perform_var = f;
    return;
}

int Scala_performKsmps() {
    int res = scala_perform_var();
    return res;
}

void call_scala_func() {
  scala_func_var(0);
  return;
}

void Scala_setOutputBuffer(double* b) {
  output_buffer = b;
  return;
}

double* Scala_getOutputBuffer() {
  return output_buffer;
}
