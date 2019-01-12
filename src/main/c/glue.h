typedef void (*scala_arg_callback_func)(void*);

typedef int (*scala_perform_func)();

extern scala_arg_callback_func scala_func_var;

extern double* output_buffer;

extern scala_perform_func scala_perform_var;