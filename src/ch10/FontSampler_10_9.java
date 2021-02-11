package ch10;

import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * This program allow the user to type in a font name and
 * then displays a line of text using the font.
 */
public class FontSampler_10_9 extends GraphicsProgram{
	
	public void run() {
		fontField = new JTextField(MAX_FONT_NAME);
		fontField.addActionListener(this);  //addActionListener
		add(new JLabel("Font"), SOUTH);
		add(fontField, SOUTH);
		lastY = 0;
		lastLabel = new GLabel(TEST_STRING);
		addGLable(lastLabel);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == fontField) {
			GLabel label = new GLabel(TEST_STRING);
			label.setFont(lastLabel.getFont());    //這邊要先設定成lastLabel字體的原因是怕使用者沒有輸入
			label.setFont(fontField.getText());
			addGLable(label);
			lastLabel = label;
		}
	}
	
	private void addGLable(GLabel label) {
		//新的label的Y = 上一個的getHeight() + (兩個Descent的差)
		lastY += lastLabel.getHeight();
		lastY += (lastLabel.getDescent() - label.getDescent());
		add(label, LEFT_MARGIN, lastY);
	}
	//Private constants
	private static final int MAX_FONT_NAME = 30;
	private static final int LEFT_MARGIN = 3;
	private static final String TEST_STRING = "The quick browm fox jumped over the lazy dogs.";
	
	//Private instance variables
	private JTextField fontField;
	private GLabel lastLabel;
	private double lastY;
}
