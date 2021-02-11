package ch2;/*
 * File: Hello program
 * Purpose: 在螢幕上顯示 Hello world!
 */

import acm.program.*;
import acm.graphics.*;

public class HelloProgram2_1 extends GraphicsProgram {
	public void run() {
		add(new GLabel("Hello world!", 100, 75));
	}
}

