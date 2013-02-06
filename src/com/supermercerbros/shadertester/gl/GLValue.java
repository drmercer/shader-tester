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

/**
 * Represents a value in a shader in OpenGL
 */
interface GLValue {
	void printTo(PrintStream out);
	
	// SUBCLASSES
	
	public static class Vec implements GLValue {
		private static final String FMT = "% .4f";
		
		private final float[] elements;
		private final int count;
		
		public Vec(float... elements) {
			this.count = elements.length;
			if (count < 1 || count > 4) {
				throw new IllegalArgumentException("Improper element count");
			}
			
			this.elements = elements;
		}
		
		@Override
		public void printTo(PrintStream out) {
			StringBuilder sb;
			if (count != 1) {
				sb = new StringBuilder("vec");
				sb.append(count);
				sb.append("< ");
				sb.append(String.format(FMT, elements[0]));
				for (int i = 1; i < count; i++) {
					sb.append(", ");
					sb.append(String.format(FMT, elements[i]));
				}
				sb.append(" >");				
			} else {
				sb = new StringBuilder("float ");
				sb.append(String.format(FMT, elements[0]));
			}
			out.println(sb.toString());
		}	
	}
}
