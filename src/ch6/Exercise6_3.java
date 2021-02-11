package ch6;/*
 * File:MonteCarloIntegration
 * Purpose: Give an approximate value of pi using  Monte Carlo integration.
 */

import acm.program.*;
import acm.util.*;


public class Exercise6_3 extends ConsoleProgram{
	
	public void run() {

		int dartInCircle = 0;
		for(int i = 1; i <= NDARTS; i++) {
			double x = rgn.nextDouble(-1.0, 1.0);
			double y = rgn.nextDouble(-1.0, 1.0);
			if(x * x + y * y <= 1)
				dartInCircle++;
		}
		/* Note: Area of circle = pi * r * r
		 * 		 Area of square = 2r * 2r = 4 * r * r
		 * 		 So, dartInCircle : NDARTS = pi * r * r : 4 * r * r
		 * 		 ->pi = 4 * dartInCircle * NDARTS
		 */
		double pi = 4.0 * dartInCircle / NDARTS;
		println("Pi is approximately " + pi);
		
	}
	
	private static final int NDARTS = 1000000;
	
	private RandomGenerator rgn = RandomGenerator.getInstance();

}
