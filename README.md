ShaderTester
============

ShaderTester (WIP) will be a Java program that allows OpenGL developers (particularly Android developers) to test run their GLSL shaders line-by-line. Often times it is difficult to debug GLSL shaders because (unlike Java or other CPU languages) one cannot output variables from a shader to a debug log or something similar (i.e. System.out).

What does it do so far?
-----------------------
At this point, [Main.java][] is simply a demo of what the other library classes can do. It loads a text file containing buffer data as a ByteBuffer and parses that ByteBuffer to find the values of certain attributes at certain verts. Although primitive, this is useful, as it helped me to **(a)** figure out that endianness needs to be considered when loading bytes into a float-based VBO and **(b)** figure out that a lack of such consideration was the/a cause of my skeletal animation problems with [Schooner 3D][].

[Main.java]: https://github.com/drmercer/shader-tester/blob/master/src/com/supermercerbros/shadertester/Main.java
[Schooner 3D]: https://github.com/drmercer/Schooner-3D
