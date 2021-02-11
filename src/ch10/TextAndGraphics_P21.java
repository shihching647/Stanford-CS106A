package ch10;

import acm.program.*;
import acm.graphics.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;


public class TextAndGraphics_P21 extends ConsoleProgram{
	
	public void init() {
		setLayout(new GridLayout(1, 3));
		
		//add Canvas to GridLayout
		leftCanvas = new GCanvas();
		add(leftCanvas);
		rightCanvas = new GCanvas();
		add(rightCanvas);
		
		//add textField
		add(new JLabel("Source text:"), SOUTH);
		text = new JTextField(MAX_TEXT);
		add(text, SOUTH);
		text.addActionListener(this);
		
		//add Button
		add(new JButton("Draw left"), SOUTH);
		add(new JButton("Draw right"), SOUTH);
		addActionListeners();
	}
	
	public void actionPerformed(ActionEvent e) {
		//JTextField
		if(e.getSource() == text) {
			println("You typed: " + text.getText());
			text.setText("");
		}
		//JButton
		String cmd = e.getActionCommand();
		if(cmd.equals("Draw left")) {
			leftCanvas.add(createRect(), X, leftY);
			leftY += RECT_HEIGHT + SPACE;
		}else if(cmd.equals("Draw right")) {
			rightCanvas.add(createRect(), X, rightY);
			rightY += RECT_HEIGHT + SPACE;
		}
	}
	
	
	
	private GRect createRect() {
		GRect rect = new GRect(RECT_WIDTH, RECT_HEIGHT);
		rect.setFilled(true);
		return rect;
	}



	private static final int MAX_TEXT = 15;
	private static final int RECT_WIDTH = 60;
	private static final int RECT_HEIGHT = 25;
	private static final int X = 5;
	private static final int SPACE = 15;
	
	
	private GCanvas leftCanvas;
	private GCanvas rightCanvas;
	private JTextField text;
	private int leftY = 10;
	private int rightY = 10;
}
