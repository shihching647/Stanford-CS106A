package ch13;

public class SimpleStringMap {
	
	public SimpleStringMap() {
		bucketArray = new HashEntry[N_BUCKET];
	}
	
	public void put(String key, String value) {
		int bucket = Math.abs(key.hashCode()) % N_BUCKET;
		HashEntry entry = findEntry(bucketArray[bucket], key);
		if(entry == null) {
			//如果沒找到這個HashEntry, 新增一個,把原來在bucketArray[bucket]的那一個接到新的後面, 再把新的存到bucketArray[bucket]
			entry = new HashEntry(key, value);
			entry.setEntryLink(bucketArray[bucket]);
			bucketArray[bucket] = entry;
		}else {
			entry.setValue(value);
		}
	}
	
	public String get(String key) {
		int bucket = Math.abs(key.hashCode() % N_BUCKET);
		HashEntry entry = findEntry(bucketArray[bucket], key);
		if(entry != null) {
			return entry.getValue();
		}
		return null;
	}
	
	private HashEntry findEntry(HashEntry entry, String key) {
		while(entry != null) {
			if(entry.getKey().equals(key)) return entry;
			entry = entry.getEntryLink();
		}
		return null;
	}
	
	public void printMap() {
		for(int i = 0; i < N_BUCKET; i++) {
			HashEntry entry = bucketArray[i];
			while(true) {
				if(entry == null) {
					System.out.print("null");
					break;
				}
				System.out.print("(" + entry.getKey() + ", " + entry.getValue() + ") --> ");
				entry = entry.getEntryLink();
			}
			System.out.println();
		}
	}
	
	private static final int N_BUCKET = 7;
	private HashEntry[] bucketArray;

}

class HashEntry{
	
	private String key;
	private String value;
	private HashEntry entryLink;
	
	public HashEntry(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public HashEntry getEntryLink() {
		return entryLink;
	}
	public void setEntryLink(HashEntry entryLink) {
		this.entryLink = entryLink;
	}
	
	
}