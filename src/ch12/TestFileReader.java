package ch12;/*
 * File: TestFileReader
 * Purpose: Using BufferedReader read a text line by line.
 */

import acm.program.*;
import java.io.*;
import acm.util.*;

public class TestFileReader extends ConsoleProgram{
	
	public void run(){
		BufferedReader rd = openFileReader("請輸入檔案名稱: ");
		//Reading file is dangerous,so need a try-catch block.
		//不知道怎麼處理exception(如檔案壞掉)
		try{
			while(true) {
				String line = rd.readLine();
				if(line == null) break;
				println(line);
			}
			rd.close();
		}catch (IOException ex) {
			throw new ErrorException(ex); //不知道怎麼處理exception throw new ErrorException(ex)要import acm.util.*;
		}
		
	}
	
	//Opening file is dangerous,so need a try-catch block.
	//知道怎麼處理exception(沒有這個檔案,請重新輸入)
	private BufferedReader openFileReader(String prompt) {
		BufferedReader rd = null;
		while(rd == null) {
			try {
				String name = readLine(prompt);
				rd = new BufferedReader(new FileReader("src/ch12/" + name));
			}catch (IOException ex) {
				println("沒有這個檔案,請重新輸入!");
			}
		}
		return rd;
	}

}
