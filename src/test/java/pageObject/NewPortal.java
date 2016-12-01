package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webDriver.Driver;

import java.io.IOException;

/**
 * Created by syn3286 on 18/05/2016.
 */
public class NewPortal {

    public WebElement LoggedIn() throws IOException {
        return Driver.findElement(By.xpath("//*[@class='title h1']//*[contains(text(), 'Your content')]"));
    }

    public WebElement LogOutButton() throws IOException {
        return Driver.findElement(By.xpath("//*[@class='js-logout']"));
    }

}
