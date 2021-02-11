package ch2;/*
 * File: Hello program
 * Purpose: 在螢幕上顯示 Hello world!並更改顏色,字體.
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;  //更改顏色(AWT = Abstract Windowing Toolkit)

public class HelloProgram2_4_changeFont extends GraphicsProgram {
	public void run() {
		GLabel msg = new GLabel("Hello world!", 100, 75);
		msg.setFont("Dialog-24"); //更改字型大小
		msg.setColor(Color.blue);
		add(msg);
	}
}

