package enums;

public enum NewPortalLanguage {

	Vietnamese(0),
	Thai(1),
	Spanish(2),
	Portugues(3),
	Polish(4),
	Korean(5),
	Japanese(6),
	English(7),
	Chinese(8),
	ChineseTraditional(9);


	private int value;
	private NewPortalLanguage(int value){
		
		this.value = value;
	}
	
	public int getLanguageValue(){
		
		return this.value;
	}
}
