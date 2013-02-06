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

package com.supermercerbros.shadertester;

import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.util.Scanner;

import com.supermercerbros.shadertester.gl.GLClone;
import com.supermercerbros.shadertester.util.BufferLoader;


/**
 * @author Dan Mercer
 *
 */
public class Main {
	private static final String FILEPATH = "";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Get filepath
		final String filepath;
		if (FILEPATH.isEmpty()) {
			final Scanner in = new Scanner(System.in);
			System.out.print("Filepath: ");
			filepath = in.nextLine();
		} else {
			filepath = FILEPATH;
		}
		
		
		// Parse file to buffer
		ByteBuffer b;
		try {
			b = BufferLoader.getBufferFromFile(filepath, true);
		} catch (FileNotFoundException e) {
			System.err.println("File does not exist or cannot be read.");
			return;
		}
		
		GLClone gl = new GLClone();
		gl.glBufferData(b);
		gl.glVertexAttribPointer("a_pos    ", 3, GLClone.GL_FLOAT, false, 32, 0);
		gl.glVertexAttribPointer("a_weights", 4, GLClone.GL_FLOAT, false, 32, 12);
		gl.glVertexAttribPointer("a_indices", 4, GLClone.GL_BYTE, false, 32, 28);
		
		gl.printValuesAt(0);
		gl.printValuesAt(1);
	}
	
}
