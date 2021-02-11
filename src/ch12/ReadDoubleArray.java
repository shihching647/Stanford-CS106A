package ch12;

import acm.program.*;
import java.util.*;
import java.io.*;

public class ReadDoubleArray extends ConsoleProgram{
	
	public void run() {
		Reader rd = null;
		try {
			rd = new FileReader("src/ch12/double.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		double[] numbers = readDoubleArray(rd);
		print("[");
		for(int i = 0; i < numbers.length; i++) {
			print( i != numbers.length - 1 ? numbers[i] + ", " : numbers[i] + "]");
		}
	}
	
	private double[] readDoubleArray(Reader rd) {
		ArrayList<Double> doubleList = new ArrayList<Double>();
		Scanner scanner = new Scanner(rd);
		while(scanner.hasNextDouble()) {
			double num = scanner.nextDouble();
			doubleList.add(num);
		}
		double[] result = new double[doubleList.size()];
		for(int i = 0; i < result.length; i++) {
			result[i] = doubleList.get(i);
		}
		scanner.close();
		return result;
	}
}
