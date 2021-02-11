package ch9;/*
 * File:StopSign
 * Purpose:創造一個Stop sign
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;


public class GFaceExample9_19 extends GraphicsProgram{
	
	public void run() {
		GFace face = new GFace(50.0, 100.0);
		add(face, getWidth() / 2, getHeight() / 2);

	}
	
	public class GFace extends GCompound{
		
		//Constructor
		public GFace (double width, double height) {
			//先把五官建出來
			GOval head = new GOval(width, height);
			GOval leftEye = new GOval(EYE_WIDTH * width, ETE_HEIGHT * height);
			GOval rightEye = new GOval(EYE_WIDTH * width, ETE_HEIGHT * height);
			GPolygon noise = createNoise(NOISE_WIDTH * width, NOISE_HEIGHT * height);
			GRect mouth = new GRect(MOUTH_WIDTH * width, MOUTH_HEIGHT * height);
			//把五官貼到GCompound,以臉的左上角為reference
			add(head, 0, 0);
			add(leftEye, width / 4 - EYE_WIDTH * width / 2, height / 4 - ETE_HEIGHT * height /2);
			add(rightEye, 3 * width / 4 - EYE_WIDTH * width / 2, height / 4 - ETE_HEIGHT * height /2);
			add(noise, width / 2, height / 2);
			add(mouth, width / 2 - MOUTH_WIDTH * width / 2, 3 * height / 4 - MOUTH_HEIGHT * height / 2);
			
		}
		
		private GPolygon createNoise(double width, double height) {
			GPolygon noise = new GPolygon();
			noise.addVertex(0, -height / 2);
			noise.addVertex(width / 2, height / 2);
			noise.addVertex(-width / 2, height / 2);
			return noise;
		}
		
	}

	//Constants specifying feature size as a fraction of head size
	private static final double EYE_WIDTH 	 = 0.15;
	private static final double ETE_HEIGHT 	 = 0.15;
	private static final double NOISE_WIDTH  = 0.15;
	private static final double NOISE_HEIGHT = 0.10;
	private static final double MOUTH_WIDTH  = 0.50;
	private static final double MOUTH_HEIGHT = 0.03;

}
