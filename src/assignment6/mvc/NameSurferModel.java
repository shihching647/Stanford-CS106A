package assignment6.mvc;

import java.util.*;

public class NameSurferModel {
	
	private NameSurferDataBase db;
	private ArrayList<NameSurferEntry> nameList;
	private ArrayList<NameSurferView> viewList;
	
	/*Create a new NameSurferModel with DataBase and no views/names */
	public NameSurferModel(String fileName){
		try {
			db = new NameSurferDataBase(fileName);
			viewList = new ArrayList<NameSurferView>();
			nameList = new ArrayList<NameSurferEntry>();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void addEntry(NameSurferEntry entry) {
		if(entry != null)
			nameList.add(entry);
		notifyViews();
	}
	
	public ArrayList<NameSurferEntry> getEntries(){
		return nameList;
	}
	
	public void addView(NameSurferView view) {
		viewList.add(view);
		notifyViews();
	}
	
	public void removeView(NameSurferView view) {
		viewList.remove(view);
		notifyViews();
	}
	
	public NameSurferDataBase getDataBase() {
		return db;
	}
	
	public void clear() {
		nameList.clear();
		notifyViews();
	}
	
	public void notifyViews() {
		for(int i = 0; i < viewList.size(); i++) {
			viewList.get(i).update(this);
		}
	}
}
