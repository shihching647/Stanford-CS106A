package ch13;

public class TestSimpleStringMap {

	public static void main(String[] args) {
		SimpleStringMap map = new SimpleStringMap();
		map.put("AK", "Alaska");
		map.put("AL", "Alabama");
		map.put("AR", "Arkansas");
		map.put("AZ", "Arizona");
		map.put("CA", "California");
		map.printMap();
	}

}
