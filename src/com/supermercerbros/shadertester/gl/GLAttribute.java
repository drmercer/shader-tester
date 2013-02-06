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

import java.nio.ByteBuffer;

/**
 * @author Dan Mercer
 *
 */
public class GLAttribute {
	private final String name;
	
	private final int size;
	private final int type;
	private final int stride;
	private final int offset;
	
	public GLAttribute(String name, int size, int type, int stride, int pointer) {
		this.name = name;
		this.size = size;
		this.type = type;
		this.stride = stride;
		this.offset = pointer;
	}
	
	String getName() {
		return name;
	}
	
	GLValue getValue(int vertIndex, ByteBuffer buf) {
		final float[] elements = new float[size];
		final int attribOffset = offset + stride * vertIndex;
		
		switch (type) {
		case GLClone.GL_FLOAT:
			for (int i = 0; i < size; i++) {
				int index = attribOffset + (i * 4); // 4 bytes per float
				elements[i] = buf.getFloat(index);
			}
			break;
			
		case GLClone.GL_UNSIGNED_BYTE:
			for (int i = 0; i < size; i++) {
				int index = attribOffset + i;
				elements[i] = (float) (0xFF & buf.get(index));
			}
			break;
		
		case GLClone.GL_BYTE:
			for (int i = 0; i < size; i++) {
				int index = attribOffset + i;
				elements[i] = buf.get(index);
			}
			break;
			
		default:
			return null;
		}
		
		return new GLValue.Vec(elements);
	}
}
