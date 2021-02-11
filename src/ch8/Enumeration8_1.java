package ch8;/*
 * File: Enumeration.java
 * Purpose: Give an example of enumeration.
 */

import acm.program.*;

public class Enumeration8_1 extends ConsoleProgram{
	
	public enum Weekday{
		SUNDAY, MONDAY, TUESDAY, WENDESDAY, THURSDAY, FRIDAY, SATURDAY
	}
	
	public void run() {
		
		Weekday day1 = Weekday.SATURDAY;  //宣告day1為一個Weekday
		println("Is " + day1 + " is a weekend day? " + isWeekendDaySwitch(day1));
		println("Is " + day1 + " is a weekend day? " + isWeekendDayBoolean(day1));

	}

	//用switch寫的話,直接SATURDAY
	private boolean isWeekendDaySwitch(Weekday day) {
		
		switch(day) {
		case SATURDAY: case SUNDAY: return true;
		default: return false;
		}
		
	}
	
	//用boolean logic寫的話要用Weekday.SATURDAY
	private boolean isWeekendDayBoolean(Weekday day) {
		return (day == Weekday.SATURDAY || day == Weekday.SUNDAY);  
	}
}

