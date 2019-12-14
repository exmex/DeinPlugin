package Utils;

public enum Language {

	GERMAN ("DE", 1), 
	ENGLISH ("EN", 2);
	
	private String display;
	private int id;
	
	Language (String display, int id) {
		this.display = display;
		this.id = id;
	}
	
	public String getDisplay() {
		return this.display;
	}
	
	public int getID() {
		return this.id;
	}
	
}
