package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends basePage{

	
 WebDriver driver;
 
 //Constructor
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	
	//Locators
	@FindBy(xpath="//div[@class='panel header']/ul[@class=\"header links\"]/li/a[contains(text(),\"Create an Account\")]")
	WebElement createAccount;
	
	@FindBy(xpath="//div[@class='panel header']//a[contains(text(),'Sign In')]")
	 public WebElement signINLink;
	
	 
	 
	 
	//Action methods
	public void clickCreateaccpunt()
	{
		createAccount.click();
	}
	
	public void clikSignIn()
	  {
		  signINLink.click();
	  }
}
