package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import webDriver.Driver;

public class Register {

    public WebElement FirstName () { return Driver.findElement(By.id("_FirstName"));}
    public WebElement Surname () { return Driver.findElement(By.id("_LastName"));}
    public WebElement NextButton () {return Driver.findElement(By.id("_nextBtn"));}
    public WebElement Email () {return Driver.findElement(By.id("_EmailAddress"));}
    public WebElement EmailConfirm () {return Driver.findElement(By.id("_ConfirmEmailAddress"));}
    public WebElement optInCheckbox () {return Driver.findElement(By.id("_MacmillanOptIn"));}
    public WebElement helpIcon () {return Driver.findElement(By.id("help"));}
    public WebElement EmailAddress () {return Driver.findElement(By.id("_EmailAddress"));}
    public WebElement ConfirmEmail () {return Driver.findElement(By.id("_ConfirmEmailAddress"));}
    public WebElement TermsLink () {return Driver.findElement(By.id("_TermsOfUse"));}
    public WebElement PrivacyPolicy () {return Driver.findElement(By.id("_PrivacyPolicy"));}
    public WebElement OptInCheckbox () {return Driver.findElement(By.id("_MacmillanOptIn"));}
    public WebElement SubmitButton () {return Driver.findElement(By.id("_submitBtn"));}
    public WebElement BackButton () {return Driver.findElement(By.id("_backBtn"));}
    public static Select CountrySelector() {return new Select(Driver.findElement(By.xpath("//*[@data-flux-key='countryOfResidence']")));}
    public static Select DaySelector () {return new Select(Driver.findElement(By.xpath("//*[@id='_DateOfBirth_Day']")));}
    public static Select MonthSelector () {return new Select(Driver.findElement(By.xpath("//*[@id='_DateOfBirth_Month']")));}
    public static Select YearSelector () {return new Select(Driver.findElement(By.xpath("//*[@id='_DateOfBirth_Year']")));}
}