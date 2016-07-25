package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webDriver.Driver;

public class Popup {

	public By InstallState(int state) {
		return By.xpath("//span[@on='installInfo.state']//h1[@ng-switch-when='" + state + "']");
	}
	
	public By Downloading() {
		
		return InstallState(1);
	}
	
	public By Failure() {
		
		return InstallState(2);
	}
	
	public By Success() {

		return InstallState(3);
	}
	
	public Boolean DownloadSuccessful() {
		if (Driver.findElement(Success()).isDisplayed()) {
			return true;
		}
		return false;
	}
	
	public void WaitUntilFinished() throws Exception {
		
		new WebDriverWait(Driver.webdriver, 2).until(ExpectedConditions.visibilityOfElementLocated(Downloading()));
		System.out.println("Downloading");
		try {
			new WebDriverWait(Driver.webdriver, 600).until(ExpectedConditions.visibilityOfElementLocated(Success()));
		} catch (TimeoutException e) {
			Driver.writeToReport("Downloaded not successful after 10 minutes.");
			if (Driver.findElement(Failure()).isDisplayed()) {
				Driver.embedScreenshot();
				throw new Exception("The download finished unsuccessfully.");
			}
		}
		System.out.println("Done");
	}
}
