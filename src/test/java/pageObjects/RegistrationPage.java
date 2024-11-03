package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends basePage{
	
	WebDriver driver;
	
  ///Constructor
	  public RegistrationPage (WebDriver driver)
	  {
		  super(driver);
	  }
	  
	  //Locators
	  
	  @FindBy(xpath="//input[@id=\"firstname\"]")
	  WebElement firstNameTxt;
	  
	  @FindBy(xpath="//input[@id=\"lastname\"]")
	  WebElement lastNameTxt;


	  @FindBy(xpath="//input[@id=\"email_address\"]")
	  WebElement emailTxt;
	  
	  @FindBy(xpath="//input[@id=\"password\"]")
	  WebElement passwordTxt;
	  
	  @FindBy(xpath="//input[@id=\"password-confirmation\"]")
	  WebElement confirmpasswordTxt;
	  
	  @FindBy(xpath="//button[@type=\"submit\"]/span[contains(text(),\"Create an Account\")]")
	  WebElement clickCreateAnAccount;
	  
	
	  
	  
	  
	  
	  
}

