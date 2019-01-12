#!/bin/sh
# sbt nativeLink
emcc target/scala-2.11/native/lib/*.c src/main/c/*.c target/scala-2.11/native/lib/gc/none/**.c target/scala-2.11/native/lib/*.cpp target/scala-2.11/native/*.ll -s WASM=1 -s ALLOW_MEMORY_GROWTH=1 -s ERROR_ON_UNDEFINED_SYMBOLS=0 -s EXPORTED_FUNCTIONS='["_call_scala_func","_main","_Scala_setOutputBuffer","_Scala_getOutputBuffer","_Scala_performKsmps"]' -s EXTRA_EXPORTED_RUNTIME_METHODS='["ccall", "cwrap"]' -o index.html
