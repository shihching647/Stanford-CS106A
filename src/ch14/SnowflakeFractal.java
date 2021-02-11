package ch14;/*
 * File: SnowflakeFractal.java
 * ---------------------------
 * This class is a graphical object that appears as a
 * fractal snowflake.
 */

import acm.graphics.*;

/**
 * Defines a new GObject class that appears as a snowflake fractal.  Because
 * the result is a GPolygon, you can fill the snowflake or move it as a unit.
 */
public class SnowflakeFractal extends GPolygon {

/**
 * Creates a new SnowflakeFractal centered at the origin with the
 * specified edge length and fractal order.
 * @param edge The length of an edge in the order-0 snowflake
 * @param order The order of this fractal
 */
	public SnowflakeFractal(double edge, int order) {
		addVertex(-edge / 2, -edge / (2 * Math.sqrt(3)));
		addFractalLine(edge, 0, order);
		addFractalLine(edge, -120, order);
		addFractalLine(edge, +120, order);
	}

/**
 * Adds a fractal line to the polygon with the specified radial
 * length, starting angle, and fractal order.
 * @param r The length of the line
 * @param theta The direction in which to draw the line (in degrees)
 * @param order The order of this fractal
 */
	private void addFractalLine(double r, int theta, int order) {
		if (order == 0) {
			addPolarEdge(r, theta);
		} else {
			addFractalLine(r / 3, theta, order - 1);
			addFractalLine(r / 3, theta + 60, order - 1);
			addFractalLine(r / 3, theta - 60, order - 1);
			addFractalLine(r / 3, theta, order - 1);
		}
	}

}
