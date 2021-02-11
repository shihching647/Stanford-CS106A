package assignment2;/*
 * File: ProgramHierarchy.java
 * Name: 
 * Section Leader: 
 * ---------------------------
 * This file is the starter file for the ProgramHierarchy problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class ProgramHierarchy extends GraphicsProgram {	
	public void run() {
		//取中心直接getWidth() / 2, getHeight() / 2
		//若是需要用到GRect,GOval才需要用到(getWidth() - LABEL_WIDTH) / 2
		double xc = getWidth() / 2;
		double yc = getHeight() / 2;
		//Program
		double xProgram = xc - LABEL_WIDTH / 2;
		double yProgrom = yc - SPACE_HEIGHT - LABEL_HEIGHT;
		Label program = new Label(LABEL_WIDTH, LABEL_HEIGHT, "Program");
		add(program, xProgram, yProgrom);
		//ConsoleProgram
		double xCProgram = xc - LABEL_WIDTH / 2;
		double yCProgrom = yc;
		Label CProgram = new Label(LABEL_WIDTH, LABEL_HEIGHT, "ConsoleProgram");
		add(CProgram, xCProgram, yCProgrom);
		//GraphicsProgram
		double xGProgram = xCProgram - LABEL_WIDTH - SPACE_WIDTH;
		double yGProgrom = yc;
		Label GProgram = new Label(LABEL_WIDTH, LABEL_HEIGHT, "GraphicsProgram");
		add(GProgram, xGProgram, yGProgrom);
		//DialogProgram
		double xDProgram = xc + LABEL_WIDTH / 2 + SPACE_WIDTH;
		double yDProgrom = yc;
		Label DProgram = new Label(LABEL_WIDTH, LABEL_HEIGHT, "DialogProgram");
		add(DProgram, xDProgram, yDProgrom);
		//畫線
		add(new GLine(xc, yc, xc, yc - SPACE_HEIGHT));
		add(new GLine(xc, yc - SPACE_HEIGHT, xc + LABEL_WIDTH + SPACE_WIDTH, yc));
		add(new GLine(xc, yc - SPACE_HEIGHT, xc - LABEL_WIDTH - SPACE_WIDTH, yc));
		
	}
	
	public class Label extends GCompound {
		
		public Label(double width, double height, String str) {
			add(new GRect(0, 0, width, height));
			GLabel text = new GLabel(str);
			text.setFont("Dialog-14");
			add(text, (width - text.getWidth()) / 2, (height + text.getAscent()) / 2);
		}
	}
	
	private static final double LABEL_WIDTH= 150;
	private static final double LABEL_HEIGHT = 60;
	private static final double SPACE_WIDTH = 30;
	private static final double SPACE_HEIGHT = 50;
}

