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

package com.supermercerbros.shadertester.ui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Terminates the Java program when the window is closed.
 */
public class ExitListener extends WindowAdapter {

	@Override
	public void windowClosed(WindowEvent arg0) {
		System.exit(0);
	}
	
}
