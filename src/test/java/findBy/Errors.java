
package findBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webDriver.Driver;

public class Errors {
	
	public static WebElement incorrectLoginDetails() {
		return Driver.findElement(By.xpath("//*[contains(@class,'mee-error') and contains(text(),'Your details do not match our database.')]"));
	}
	
}