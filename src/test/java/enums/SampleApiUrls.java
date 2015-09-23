package enums;

import stepDefinition.Environment;

public enum SampleApiUrls {
	test("https://sample-api-urls.com");
//	dev(""),
//	UAT("")
//	production("");
	
	private String value;
	private SampleApiUrls(String value){
		this.value = value;
	}
	
	public String getValue() {

		return this.value;
	}

	public static String getUrl() {
		return SampleApiUrls.valueOf(Environment.environment).getValue();
	}
}
