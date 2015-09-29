package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import webDriver.Driver;


public class SampleGooglePageObject {

	public WebElement googleSearchField() {
		
		return Driver.findElement(By.id("lst-ib"));
	}
	
	public WebElement googleSearchButton() {
		
		return Driver.findElement(By.name("btnG"));
	}
}
