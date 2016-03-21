package enums;

import stepDefinition.Environment;

public enum MeeAdminPortal {

		test("https://mee-test-admin.ws.macmillaneducation.com/"),
		dev("http://mee-dev-adminportal.cloudapp.net/"),
		UAT("https://mee-uat-admin.ws.macmillaneducation.com/"),
		production("https://mee-admin.ws.macmillaneducation.com");
		
		private String value;
		private MeeAdminPortal(String value){
			
			this.value = value;
		}
		
		public String getValue(){
			
			return this.value;
		}
		
		public static String getUrl() {
			return MeeAdminPortal.valueOf(Environment.environment).getValue();
		}
	}
