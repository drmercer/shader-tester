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

package com.supermercerbros.shadertester.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Scanner;

/**
 * Loads ByteBuffers from files
 */
public class BufferLoader {
	
	/**
	 * Parses a ByteBuffer from the given file. If the file is text, it should
	 * start with the length of the buffer, followed by the bytes to be in the
	 * buffer. All numbers should be separated by commas, whitespace, or
	 * end-of-lines. For example:
	 * 
	 * <pre>
	 * 4
	 * 128,
	 * 32,
	 * -45,
	 * 23,
	 * </pre>
	 * 
	 * Binary is not yet supported.
	 * 
	 * @param filename
	 *            The path to the file to parse
	 * @param text
	 *            true if the file is text, false if binary. TODO: add support
	 *            for binary
	 * @return A ByteBuffer containing the data from the file.
	 * 
	 * @throws FileNotFoundException If the file cannot be opened.
	 */
	public static ByteBuffer getBufferFromFile(String filename, boolean text)
			throws FileNotFoundException {
		final FileInputStream fileInputStream = new FileInputStream(new File(
				filename));
		
		return getBufferFromInputStream(fileInputStream, text);
		
	}
	
	/**
	 * @param fileInputStream
	 * @param text
	 * @return
	 */
	public static ByteBuffer getBufferFromInputStream(
			final FileInputStream fileInputStream, boolean text) {
		if (text) {
			final Scanner in = new Scanner(fileInputStream);
			in.useDelimiter("[,\\s]");
			
			final int size = in.nextInt();
			final ByteBuffer b = ByteBuffer.allocate(size).order(
					ByteOrder.nativeOrder());
			// Endianness is a problem when intermingling bytes with floats in
			// VBOs
			
			while (in.hasNext()) {
				if (in.hasNextByte()) {
					b.put(in.nextByte());
				} else {
					in.next();
				}
			}
			
			in.close();
			return b;
		} else {
			// Binary parsing.
			
			return null;
		}
	}
	
}
