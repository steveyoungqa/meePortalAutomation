package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webDriver.Driver;

import java.io.IOException;

/**
 * Created by syn3286 on 18/05/2016.
 */
public class HelpPage {

    //Help Section links

    public WebElement HelpHeader() throws IOException {
        return Driver.findElement(By.xpath("//*[@name='_Help']"));
    }

    public WebElement SystemReqs() throws IOException{
        return Driver.findElement(By.cssSelector("a[href='#_System_Requirements']"));
    }

    public WebElement HowAccess() throws IOException{
        return Driver.findElement(By.cssSelector("a[href='#_How_do_I']"));
    }

    public WebElement HowMeeLinux() throws IOException{
        return Driver.findElement(By.cssSelector("a[href='#_How_do_I_Linux']"));
    }

    public WebElement HowRegister() throws IOException{
        return Driver.findElement(By.cssSelector("a[href='#_How_do_I_1"));
    }

    public WebElement HowLogin() throws IOException{
        return Driver.findElement(By.cssSelector("a[href='#_How_do_I_2"));
    }

    public WebElement HowRequestUserPass() throws IOException{
        return Driver.findElement(By.cssSelector("a[href='#_How_do_I_3"));
    }

    public WebElement HowFindCode() throws IOException{
        return Driver.findElement(By.cssSelector("a[href='#_How_do_I_4"));
    }

    public WebElement HowActivateCode() throws IOException{
        return Driver.findElement(By.cssSelector("a[href='#_How_do_I_5"));
    }

    public WebElement HowAccessResource() throws IOException{
        return Driver.findElement(By.cssSelector("a[href='#_How_do_I_6"));
    }

    public WebElement WhyResource() throws IOException{
        return Driver.findElement(By.cssSelector("a[href='#_Why_cant_I"));
    }

    public WebElement WhyNoDownload() throws IOException{
        return Driver.findElement(By.cssSelector("a[href='#_Why_can_I"));
    }

    public WebElement HowChangeProfile() throws IOException{
        return Driver.findElement(By.cssSelector("a[href='#_How_do_I_7"));
    }

    public WebElement HowNewVersion() throws IOException{
        return Driver.findElement(By.cssSelector("a[href='#_How_will_I"));
    }

    public WebElement UpdateLinux() throws IOException{
        return Driver.findElement(By.cssSelector("a[href='#_How_do_I_update_Linux"));
    }

    public WebElement RemoveResource() throws IOException{
        return Driver.findElement(By.cssSelector("a[href='#_How_do_I_8"));
    }

    public WebElement ChangeLanguage() throws IOException{
        return Driver.findElement(By.cssSelector("a[href='#_How_do_I_9"));
    }

    public WebElement CloseMeeApp() throws IOException{
        return Driver.findElement(By.cssSelector("a[href='#_How_do_I_10"));
    }

    public WebElement GetMoreHelp() throws IOException{
        return Driver.findElement(By.cssSelector("a[href='#_How_do_I_11"));
    }
}
