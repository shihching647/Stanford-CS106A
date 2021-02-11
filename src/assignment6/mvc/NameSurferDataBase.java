package assignment6.mvc;
/*
 * File: NameSurferDataBase.java
 * -----------------------------
 * This class keeps track of the complete database of names.
 * The constructor reads in the database from a file, and
 * the only public method makes it possible to look up a
 * name and get back the corresponding NameSurferEntry.
 * Names are matched independent of case, so that "Eric"
 * and "ERIC" are the same names.
 */

import java.io.*;
import java.util.*;

public class NameSurferDataBase {
	private Map<String, NameSurferEntry> db = new HashMap<String, NameSurferEntry>();
	
/* Constructor: NameSurferDataBase(filename) */
/**
 * Creates a new NameSurferDataBase and initializes it using the
 * data in the specified file.  The constructor throws an error
 * exception if the requested file does not exist or if an error
 * occurs as the file is being read.
 */
	public NameSurferDataBase(String filename) throws Exception{
		BufferedReader rd = new BufferedReader(new FileReader(new File(filename)));
		while(true) {
			String line = rd.readLine();
			if(line == null) break;
			NameSurferEntry entry = new NameSurferEntry(line);
			db.put(entry.getName(), entry);
		}
		rd.close();
	}
	
/* Method: findEntry(name) */
/**
 * Returns the NameSurferEntry associated with this name, if one
 * exists.  If the name does not appear in the database, this
 * method returns null.
 */
	public NameSurferEntry findEntry(String name) {
		//空字串處理
		if(name.isEmpty() == true) return null;
		//處理大寫小
		char firstChar = Character.toUpperCase(name.charAt(0));
		String str = name.substring(1).toLowerCase();
		String key = firstChar + str;
		return db.get(key);
	}
}

