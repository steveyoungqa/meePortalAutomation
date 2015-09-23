package enums;

import stepDefinition.Environment;

public enum SampleUrls {

		test("https://sample-test-url/"),
		dev("https://sample-dev-url/"),
		UAT("https://sample-uat-url/"),
		production("https://sample-production-url/");
		
		private String value;
		private SampleUrls(String value){
			
			this.value = value;
		}
		
		public String getValue(){
			
			return this.value;
		}
		
		public static String getUrl() {
			return SampleUrls.valueOf(Environment.environment).getValue();
		}
	}
