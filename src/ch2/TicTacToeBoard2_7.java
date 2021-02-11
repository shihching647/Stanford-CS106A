package ch2;/*
 * File: TicTacToeBoard
 * Purpose: Draw a # shape on screen.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class TicTacToeBoard2_7 extends GraphicsProgram{
	
	public void run(){
		add(new GLine(30, 60, 120, 60));
		add(new GLine(30, 90, 120, 90));
		add(new GLine(60, 30, 60, 120));
		add(new GLine(90, 30, 90, 120));
	}
}
