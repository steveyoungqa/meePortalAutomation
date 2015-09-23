package methods;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.Maildrop;
import webDriver.Driver;

public class MaildropMethods {

	public static String uuid;
	
	public void loadEmail() {
		Driver.loadPage("http://maildrop.cc/inbox/" + uuid);
	}
	
	public String[] getBodyText() {
		return Maildrop.emailBody().getText().split("\n");
	}
	
	public Map<String, String> getUsernameAndPassword() {
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
	
	public void clickEmailLink() {
		Maildrop.emailLink().get(0).click();
	}
	
	public Boolean emailIsUnavailable() {
		return Maildrop.emailLink().isEmpty();
	}
	
	public void switchToEmailBody() {
		Driver.switchToFrame(Maildrop.messageBody());
	}
	
	public void clickRefresh() {
		Maildrop.refresh().click();
	}
	
	public WebElement waitForActivationLink() {
		return new WebDriverWait(Driver.getCurrentDriver(), 10).until(ExpectedConditions.visibilityOf(Maildrop.activationLink()));
	}
	
	public void clickActivationLink() {
		waitForActivationLink().click();
	}
}
