package enums;

import stepDefinition.Environment;

public enum MeePortal {
	test("https://mee-test-useraccesscontrolmanager.ws.macmillaneducation.com/"),
	dev("http://mee-dev-useraccesscontrolmanager.cloudapp.net/"),
	UAT("https://mee-uat-useraccesscontrolmanager.ws.macmillaneducation.com/"),
	production("https://www.macmillaneducationeverywhere.com/");
	
	private String value;
	private MeePortal(String value){
		
		this.value = value;
	}
	
	public String getValue(){
		
		return this.value;
	}
	
	public static String getUrl() {
		return MeePortal.valueOf(Environment.environment).getValue();
	}
}
