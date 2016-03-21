package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import webDriver.Driver;

import java.util.List;

public class AdminPortal {

	public WebElement Username(){
		
		return Driver.findElement(By.id("Username"));
	}
	
	public static void Password(String password){
        
		@SuppressWarnings("unused")
		boolean result = false;
        int attempts = 0;
        while(attempts < 2) {
            try {
                Driver.findElement(By.id("Password")).sendKeys(password);
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }
	}
	
	public static void EditUserButtons(String userButton){
		
		List<WebElement> editProfileButtons = Driver.findElements(By.className("mee-button"));
		
		for(WebElement button : editProfileButtons){
			if(button.getAttribute("innerText").equals(userButton)){
				button.click();
				break;
			}
		}		
	}
	
	public List<WebElement> SaveChanges(){
		
		return Driver.findElements(By.className("mee-button"));
	}
	
	public WebElement EditFirstName(){
		
		return Driver.findElement(By.id("FirstName"));
	}
	
	public WebElement EditLastName(){
		
		return Driver.findElement(By.id("LastName"));
	}
	
	public WebElement EditCountry(){
		
		return Driver.findElement(By.id("Country"));
	}
	
	public WebElement Login(){
		
		return Driver.findElement(By.className("mee-button"));
	}

	public WebElement ValidationError(){
		
		return Driver.findElement(By.className("field-validation-error"));
	}
	
	public WebElement UsersSectionNavigation(){
		
		return Driver.findElement(By.id("users-list-url"));
	}
	
	public WebElement ActivationCodeSearchField(){
		
		return Driver.findElement(By.id("SearchByActivationCode"));
	}
	
	public WebElement EmailSearchField(){
		
		return Driver.findElement(By.id("SearchByEmail"));
	}
	
	public WebElement UsernameSearchField(){
		
		return Driver.findElement(By.id("SearchByUsername"));
	}
	
	public WebElement FirstNameSearchField(){
		
		return Driver.findElement(By.id("SearchByFirstname"));
	}
	
	public WebElement LastNameSearchField(){
		
		return Driver.findElement(By.id("SearchByLastname"));
	}

	public WebElement CountrySearchField(){
		
		return Driver.findElement(By.id("SearchByCountry"));
	}
	
	public WebElement UserTypeSearchField(){
		
		return Driver.findElement(By.id("SearchByUserType"));
	}
	
	public WebElement ResourceNameSearchField(){
		
		return Driver.findElement(By.id("SearchByName"));
	}
	
	public WebElement SearchButton(){
		
		return Driver.findElement(By.cssSelector("*[value='Search']"));
	}
	
	public WebElement LoginButton(){
		
		return Driver.findElement(By.cssSelector("*[value='Log in']"));
	}
	
	public WebElement EditUserButton(){
		
		return Driver.findElement(By.cssSelector("a[href*='/User/Details?UserId=99a31143-ec8e-4b87-8133-906d3ec79a10']"));
	}
		
	public WebElement SubsciptionsList(){
		
		return Driver.findElement(By.id("ui-id-1"));
	}
	
	public WebElement UpdateUsernameButton(){
		
		return Driver.findElement(By.cssSelector("a[href*='/User/ChangeUserUsername?userId=99a31143-ec8e-4b87-8133-906d3ec79a10']"));
	}
	
	public WebElement NewUsernameField(){
		
		return Driver.findElement(By.id("Username"));
	}
	
	public List<WebElement> UpdateUsernameConfirm(){
		
		return Driver.findElements(By.className("mee-button"));
	}
	
	public WebElement ResourceSeachButton(){
		
		return Driver.findElement(By.cssSelector(".mee-button.mee-align-right"));
	}
	
	public WebElement ResourceEditButton(){
		
		return Driver.findElement(By.className("mee-button-edit"));
	}
	
	public WebElement ResourceVersionsAccordion(){
		
		return Driver.findElement(By.id("ui-id-8"));
	}
	
	public WebElement ResourceBuildNumber(){
		
		return Driver.findElement(By.id("Versions_0__Build"));
	}
	
	public WebElement ResourceSave(){
		
		return Driver.findElement(By.xpath("//input[@value='Save']"));
	}
	
	public WebElement UsernameDisplayed(){
		
		return Driver.findElement(By.xpath("/html/body/div[2]/form/div/div[2]/div"));
	}
	
	public List<WebElement> ClosePopupWindow(){
		
		return Driver.findElements(By.className("close"));
	}
}
