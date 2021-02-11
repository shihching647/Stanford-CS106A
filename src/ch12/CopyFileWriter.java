package ch12;/*
 * File: CopyFileWriter
 * Purpose: Using PrinterWiter to copy a text.
 */

import acm.program.*;
import java.io.*;
import acm.util.*;

public class CopyFileWriter extends ConsoleProgram{
	
	public void run(){
		BufferedReader rd = openFileReader("Please enter file neame:");
		//Reading file and writing file are dangerous,so need a try-catch block.
		//不知道怎麼處理exception(如檔案壞掉)
		try {
			PrintWriter wr = new PrintWriter(new FileWriter("src/ch12/test_copy.txt"));
			
			while(true) {
				String line = rd.readLine();
				if(line == null) break;
				println("Copying line:[" + line + "]");
				wr.println(line);
			}
			//close file
			rd.close();
			wr.close();
		}catch (IOException ex) {
			throw new ErrorException(ex);
		}
	}
	
	//Opening file is dangerous,so need a try-catch block.
	//知道怎麼處理exception(沒有這個檔案,請重新輸入)
	private BufferedReader openFileReader(String prompt) {
		BufferedReader rd = null;
		while(rd == null) {
			try {
				String name = readLine(prompt);
				rd = new BufferedReader(new FileReader(name));
			}catch (IOException ex) {
				println("沒有這個檔案,請重新輸入!");
			}
		}
		return rd;
	}

}
