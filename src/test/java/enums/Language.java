package enums;

public enum Language {

	English(0),
	Spanish(1),
	Japanese(2),
	Korean(3),
	Taiwanese(4),
	Vitenamese(5),
	Chinese(6),
	ChineseTraditional(7);
	
	private int value;
	private Language(int value){
		
		this.value = value;
	}
	
	public int getLanguageValue(){
		
		return this.value;
	}
}
