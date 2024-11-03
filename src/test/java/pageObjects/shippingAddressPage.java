package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.BaseClass;

public class shippingAddressPage extends basePage{

	//public WebDriver driver;
	
	HomePage home;
	LoginPage login;
	Actions action;
	BaseClass baseclass;
	SearchPage search;
	
	
	//Constructor
	public shippingAddressPage(WebDriver driver)
	{
		super(driver);
		home=new HomePage(driver);
		login=new LoginPage(driver);
		action=new Actions(driver);
		search=new SearchPage(driver);
		baseclass=new BaseClass();
	}
	
	//Locators
	@FindBy(xpath="//input[@name=\"firstname\"]")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name=\"lastname\"]")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name=\"company\"]")
	public  WebElement company;
	
	@FindBy(xpath="//input[@name=\"street[0]\"]")
	public WebElement streetAddress ;
	
	@FindBy(xpath="//input[@name=\"city\"]")
	public WebElement city;
	
	
	@FindBy(xpath="//select[@name=\"region_id\"]")
	public WebElement state;


	@FindBy(xpath="//input[@name=\"postcode\"]")
	WebElement zipCode;
	
	
	@FindBy(xpath="//select[@name=\"country_id\"]")
	public WebElement country;
	
	
	@FindBy(xpath="//input[@name=\"telephone\"]")
	WebElement phone;
	
	@FindBy(xpath="//input[@type=\"radio\"]")
	WebElement radio;
	
	
	@FindBy(xpath="//span[contains(text(),\"Next\")]/parent::button")
	public WebElement next;
	
	
	
	//Action methods
	
	public void passFirstName(String fName)
	{
		firstName.sendKeys(fName);
	}
	
	
	public void passLastName(String lName)
	{
		lastName.sendKeys(lName);
	}
	
	
	public void passCompany(String companyValue)
	{
		company.sendKeys(companyValue);
	}
	
	public void clickCompany()
	{
		company.click();
	}
	
	public void passAddress(String address)
	{
		streetAddress.sendKeys(address);
	}
	
	
	public void passCity(String cityValue)
	{
		city.sendKeys(cityValue);
	}
	
	
	public void passState(String stateValue)
	{
		state.sendKeys(stateValue);
	}
	
	
	public void passZip(String zipValue)
	{
		zipCode.sendKeys(zipValue);
	}
	
	public void passCountry(String countryValue)
	{
		country.sendKeys(countryValue);
	}
	
	
	public void passPhoneNumber(String phoneValue)
	{
		phone.sendKeys(phoneValue);
	}
	
	
	public void clickRadio()
	{
		radio.click();
	}
	
	public void clickNext()
	{
		next.click();
	}
	
	
	//all the methods are available in the same method below
	
	public void loginTestAllMethods2() throws InterruptedException
	  {
		  action.moveToElement(home.signINLink).perform();
		  home.clikSignIn();	
		  Thread.sleep(2000);
		  
		  login.passEmail(baseclass.email);
		  Thread.sleep(2000);
		  login.passPassword(baseclass.password);
		  Thread.sleep(2000);
		  
		  baseclass.javaScriptClick(login.signInLoginPage);
		  //login.clickSignUp();
		  
		  action.moveToElement(search.womenOptions).perform();
		  action.moveToElement(search.topsOption).perform();
		  action.moveToElement(search.jacketsOption).perform();
		  search.clickjacketsOption();
		  Thread.sleep(2000);
		  
		  //moving to scroll up
		  baseclass.javaScriptClick(search.firstProduct);
		  
		  
		  baseclass.javaScriptClick(search.sizeProduct);
		 // search.selectSize();
		
		  baseclass.javaScriptClick(search.colorProduct);
		  //search.selectColor();
		  
		  baseclass.javaScriptClick(search.addCartButton);
		  
		  baseclass.javaScriptClick(search.inCart);
		  
		
		  
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		  WebElement element =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='top-cart-btn-checkout']")));
		  element.click();

		  
	  }
	

	
	
}
