package ch2;/*
 * File: I love Java program
 * Purpose: 在螢幕上顯示 I love Java, 且在右下角簽名
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Exercise2_1 extends GraphicsProgram{
	public void run() {
		GLabel msg = new GLabel("I love Java", 100, 75);
		GLabel name = new GLabel("劉仕卿", 200, 100);
		msg.setFont("Dialog-24");
		msg.setColor(Color.BLUE);
		name.setFont("Dialog-12");
		add(msg);
		add(name);
	}
}
