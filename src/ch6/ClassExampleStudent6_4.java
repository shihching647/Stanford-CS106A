package ch6;/*
 * File: Student.java
 * Purpose: Give a new class Student
 */

import acm.program.*;

public class ClassExampleStudent6_4 extends ConsoleProgram{
	public void run() {
		//Create an instance of Student
		Student topStudent = new Student("Jim", 3345678);
		topStudent.setCredits(31.5);
		topStudent.setPaidUp(true);
		//要用Student裡面的常數需 Student.GREDITS_TO_GRADUATE
		if(topStudent.getCredits() >= Student.GREDITS_TO_GRADUATE && topStudent.isPaidUp())
			println(topStudent + "can graduate!");
		else
			println(topStudent + "can't graduate!");
		
	}
	
	public class Student{
		
		//先定義Constructor,需與class的名稱相同
		public Student(String name, int ID) {
			studentName = name;
			studentID = ID;
		}
		
		//定義getter/setter
		public String getStudentName () {
			return studentName;
		}
		
		public int getID () {
			return studentID;
		}
		
		private void setCredits(double credits) {
			creditEarned = credits;
		}
		
		public double getCredits() {
			return creditEarned;
		}
		
		public void setPaidUp(boolean flag) {
			paidUp = flag;
		}
		
		//回傳為布林值,命名用is開頭
		public boolean isPaidUp() {  
			return paidUp;
		}
		
		//toString定義
		public String toString() {
			return studentName + "(#" + studentID + ")";
		}
		
		//定義畢業學分
		public static final double GREDITS_TO_GRADUATE = 32.0;
		
		
		//instance variable定義
		private String studentName;  //The student's name.
		private int studentID;		 //The student's ID.
		private double creditEarned; //The number of credits earned.
		private boolean paidUp;		 //Whether student is paid up.
	}
}

