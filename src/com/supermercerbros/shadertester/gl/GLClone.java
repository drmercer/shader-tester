/*
 * Copyright 2013 Dan Mercer
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.supermercerbros.shadertester.gl;

import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.util.LinkedList;

/**
 * Contains analogues of GL methods to use for testing.
 */
public class GLClone {
	public static final int GL_FLOAT = 0;
	public static final int GL_UNSIGNED_BYTE = 1;
	public static final int GL_BYTE = 2;
	
	private ByteBuffer b;
	private LinkedList<GLAttribute> attribs;
	
	public GLClone() {
		attribs = new LinkedList<GLAttribute>();
	}
	
	public void glBufferData(ByteBuffer pointer) {
		b = pointer;
	}
	
	public void glVertexAttribPointer(String attrib, int size, int type, boolean normalized, int stride, int pointer) {
		if (normalized) {
			throw new UnsupportedOperationException("normalized must be false");
		}
		attribs.add(new GLAttribute(attrib, size, type, stride, pointer));
	}
	
	public void printValuesAt(int vertexIndex) {
		printValuesAt(vertexIndex, System.out);
	}
	
	public void printValuesAt(int vertexIndex, PrintStream out) {
		out.println("VERTEX " + vertexIndex + ":");
		for (GLAttribute attrib : attribs) {
			out.print(attrib.getName() + " : ");
			attrib.getValue(vertexIndex, b).printTo(out);
		}
	}
	
}
