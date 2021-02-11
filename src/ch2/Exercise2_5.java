package ch2;/*
 * File: DrawFace
 * Purpose: Draw a face
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;


public class Exercise2_5 extends GraphicsProgram{
	public void run() {
		//Face
		GRect face = new GRect(150, 50, 150, 200);
		face.setFilled(true);
		face.setFillColor(Color.GRAY);
		add(face);
		//Eyes
		GOval leftEye = new GOval(168, 90, 30, 30);
		leftEye.setColor(Color.ORANGE);
		leftEye.setFilled(true);
		add(leftEye);
		GOval rightEye = new GOval(253, 90, 30, 30);
		rightEye.setColor(Color.ORANGE);
		rightEye.setFilled(true);
		add(rightEye);
		//nose
		GRect nose = new GRect(220, 130, 10, 20);
		nose.setColor(Color.BLACK);
		nose.setFilled(true);
		add(nose);
		//mouth
		GRect mouth = new GRect(175, 175, 100, 40);
		mouth.setColor(Color.WHITE);
		mouth.setFilled(true);
		add(mouth);
	}
}
