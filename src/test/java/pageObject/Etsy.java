package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webDriver.Driver;

import java.io.IOException;

/**
 * Created by steveyoung on 26/10/2017.
 */
public class Etsy {

    public WebElement ProductInputBox (String input) throws IOException {
        return Driver.findElement(By.id("search-query"));
    }

    public WebElement SubmitSearch(String input) throws IOException {
        return Driver.findElement(By.xpath("//*[@id='gnav-search']//*[@type='submit']"));
    }

    public WebElement EtsyHomePageLogi()throws IOException {
        return Driver.findElement(By.id("etsy-logo"));
    }

    public WebElement ProductDropdown(String product)throws IOException {
        return Driver.findElement(By.xpath("//*[contains(@class,'top-nav')]//*[contains(text(),'" + product + "')]"));
    }

    public WebElement ProductCategory(String category)throws IOException {
        return Driver.findElement(By.xpath("//*[contains(@id, 'side-nav')][contains(text(),'" + category + "')]"));
    }

    public WebElement ProductIcon(String product)throws IOException {
        return Driver.findElement(By.xpath("//*[@class='vesta-hp-category-default']//*[contains(@href,'" + product+ "')]//*[contains(@class,'card-img')]"));
    }

}
