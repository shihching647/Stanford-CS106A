package ch14;/*
 * File: AnimatedSquare.java
 * -------------------------
 * This class implements a square that executes its own thread.
 */

import acm.graphics.*;
import acm.util.*;

/**
 * This class creates an animated square that has its own thread of control.
 * Once started, the square moves in a random direction every time step.
 * After CHANGE_TIME time steps, the square picks a new random direction.
 */
public class AnimatedSquare extends GRect implements Runnable {

/** Creates a new AnimatedSquare of the specified size */
	public AnimatedSquare(double size) {
		super(size, size);
	}

/** Runs when this object is started to animate the square */
	public void run() {
		for (int t = 0; true; t++) {
			if (t % CHANGE_TIME == 0) {
				direction = rgen.nextDouble(0, 360);
			}
			movePolar(DELTA, direction);
			pause(PAUSE_TIME);
		}
	}

/* Private constants */
	private static final double DELTA = 2;     /* Pixels to move each cycle       */
	private static final int PAUSE_TIME = 20;  /* Length of time step             */
	private static final int CHANGE_TIME = 50; /* Steps before changing direction */

/* Private instance variables */
	private RandomGenerator rgen = RandomGenerator.getInstance();
	private double direction;

}
