package enums;

public enum UrlLanguage {

	English("en"),
	Spanish("es"),
	Japanese("ja"),	
	Korean("ko"),
	Thaiwanese("th"),
	Vietnamese("vi"),
	Chinese("zh-chs"),
	ChineseTraditional("zh-cht");
	
	private String value;
	private UrlLanguage(String value){
		
		this.value = value;
	}
	
	public String getLanguageValue(){
		
		return this.value;
	}
}
