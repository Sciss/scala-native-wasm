# Scala Native on WebAssembly Demo
First, locally publish https://github.com/scala-native/scala-native/pull/1363 with `sbt rebuild_x32`.

Then, run the Scala Native linker with `sbt nativeLink`, this will produce errors during compilation and linking, but this is okay because we only care about the generated LLVM.

Finally, run [Emscripten](https://kripken.github.io/emscripten-site/index.html) to compile to WebAssembly:

```bash
emcc target/scala-2.11/native/lib/*.c target/scala-2.11/native/lib/gc/none/**.c target/scala-2.11/native/lib/*.cpp target/scala-2.11/native/*.ll -s WASM=1 -s ALLOW_MEMORY_GROWTH=1 -s ERROR_ON_UNDEFINED_SYMBOLS=0 -o index.html
```

Then open up `index.html` in a web browser (you may need to serve the directory as a local server due to security restrictions).

---------------------------

## Additions HHR

The ultimate goal is to try to get an [`AudioWorkletProcessor`](https://developer.mozilla.org/en-US/docs/Web/API/Web_Audio_API#Audio_processing_in_JavaScript)
going with the [`process`](https://webaudio.github.io/web-audio-api/#dom-audioworkletprocessor-process) function served by Scala Native.

Current challenges:

- SN has no means to expose Scala members so that they would be visible to `emcc` and work through
  `-s EXPORTED_FUNCTIONS`. As a work around, we can define some C glue code which in turn is exposed
  to SN using `@extern`. Then Scala's `main` method can store the needed callback functions by
  calling the C glue code, and the glue code itself again exports a function callable from JavaScript.

Currently we can invoke the Scala function using `Module["asm"]["_call_scala_func"].apply(null)`. There is
probably a better way, I have to figure out how to use [`cwrap`](https://kripken.github.io/emscripten-site/docs/porting/connecting_cpp_and_javascript/Interacting-with-code.html#interacting-with-code-ccall-cwrap) instead.
