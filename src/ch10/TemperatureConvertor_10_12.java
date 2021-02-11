package ch10;

import acm.graphics.GMath;
import acm.gui.*;
import acm.program.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class TemperatureConvertor_10_12 extends Program{
	
	public void init() {
		setLayout(new TableLayout(2, 3));  //也可以用setLayout(new TableLayout(0, 3)); 代表永遠有3行
		fahrenheitField = new IntField(32);
		fahrenheitField.setActionCommand("F => C");
		fahrenheitField.addActionListener(this);
		add(new JLabel("Degree Fahrenheit  "));
		add(fahrenheitField);
		add(new JButton("F => C"));
		celsiusField = new IntField(0);
		celsiusField.setActionCommand("C => F");
		celsiusField.addActionListener(this);
		add(new JLabel("Degree Celsius "));
		add(celsiusField);
		add(new JButton("C => F"));
		addActionListeners();
	}
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("F => C")) {
			int f = fahrenheitField.getValue();
			int c = GMath.round(5.0 / 9.0 * (f - 32));
			celsiusField.setValue(c);
		}else if (cmd.equals("C => F")) {
			int c = celsiusField.getValue();
			int f = GMath.round(9.0 / 5.0 * c + 32);
			fahrenheitField.setValue(f);
		}
	}
	
	private IntField fahrenheitField;
	private IntField celsiusField;
	
}
