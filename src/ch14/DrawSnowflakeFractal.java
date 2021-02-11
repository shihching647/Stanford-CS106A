package ch14;/*
 * File: DrawSnowflakeFractal.java
 * -------------------------------
 * This program draws a snowflake fractal (also called a Koch fractal)
 * as described in Chapter 14.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class DrawSnowflakeFractal extends GraphicsProgram {

	public void run() {
		double cx = getWidth() / 2;
		double cy = getHeight() / 2;
		GPolygon snowflake = new SnowflakeFractal(EDGE, ORDER);
		snowflake.setFilled(true);
		snowflake.setColor(Color.RED);
		add(snowflake, cx, cy);
	}

/* Private constants */
	private static final int EDGE = 200;
	private static final int ORDER = 3;

}
