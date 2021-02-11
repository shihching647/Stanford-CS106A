package ch10;

import java.awt.*;
import acm.gui.TableLayout;
import acm.program.*;
import javax.swing.*;


public class GridAndTableLayout extends Program{
	
	public void init() {
//		setLayout(new GridLayout(2, 3));
		setLayout(new TableLayout(2, 3));
		for(int i = 1; i <= 6; i++) {
			add(new JButton("Button " + i));
		} 
		
	}
}
