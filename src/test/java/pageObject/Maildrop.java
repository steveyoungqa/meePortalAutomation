package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import webDriver.Driver;

public class Maildrop {

	public static WebElement messageBody() {
		return Driver.findElement(By.id("messageframe"));
	}
	
	public static List<WebElement> emailLink() {
		return Driver.findElements(By.xpath(".//a[contains(text(),'Your Macmillan Education Everywhere account')]"));
	}
	
	public static WebElement refresh() {
		return Driver.findElement(By.id("inbox-reload"));
	}
	
	public static WebElement activationLink() {
		return Driver.findElement(By.xpath(".//a[contains(@href,'Registration/Activation')]"));
	}
	
	public static WebElement emailBody() {
		return Driver.findElement(By.tagName("body"));
	}
	
	
}
