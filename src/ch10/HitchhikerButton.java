package ch10;/*
 * This program puts up a button on the screen, which triggers a message
 * inspired by Douglas Adam's novel.
 */

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class HitchhikerButton extends ConsoleProgram{

	public void init() {
		JButton red = new JButton("Red");
		add(red, SOUTH);
		addActionListeners();
	}
	
	//Responds to a button action.
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Red"))
			println("Please do not press this button again.");
	}
	
}
