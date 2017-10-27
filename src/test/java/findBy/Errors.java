
package findBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webDriver.Driver;

import java.io.IOException;

public class Errors {
	
	public static WebElement incorrectLoginDetails() throws IOException {
		return Driver.findElement(By.xpath("//*[contains(@class,'mee-error')]//*[contains(text(),'Your details do not match our database.')]"));
	}
	
}