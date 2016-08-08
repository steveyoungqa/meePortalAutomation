package methods;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.Maildrop;
import webDriver.Driver;

public class MaildropMethods {

	public static String uuid;
	
	public void loadEmail() throws IOException {
		Driver.loadPage("http://maildrop.cc/inbox/" + uuid);
	}
	
	public String[] getBodyText()throws IOException {
		return Maildrop.emailBody().getText().split("\n");
	}
	
	public Map<String, String> getUsernameAndPassword() throws IOException{
		String[] emailContent = getBodyText();
		Map<String, String> usernameAndPassword = new HashMap<String, String>();
		for (String line : emailContent) {
	    	if (line.contains("Username")) {
	    		usernameAndPassword.put("username", line.replace("Username: ", ""));
	    	}
	    	if (line.contains("Password")) {
	    		usernameAndPassword.put("password", line.replace("Password: ", ""));
	    	}
	    }
		return usernameAndPassword;
	}
	
	public void clickEmailLink() throws IOException{
		Maildrop.emailLink().get(0).click();
	}
	
	public Boolean emailIsUnavailable()throws IOException {
		return Maildrop.emailLink().isEmpty();
	}
	
//	public void switchToEmailBody() {
//		Driver.switchToFrame(Maildrop.messageBody());
//	}
	
	public void clickRefresh()throws IOException {
		Maildrop.refresh().click();
	}
	
	public WebElement waitForActivationLink() throws IOException{
		return new WebDriverWait(Driver.webdriver, 10).until(ExpectedConditions.visibilityOf(Maildrop.activationLink()));
	}
	
	public void clickActivationLink()throws IOException {
		waitForActivationLink().click();
	}
}
