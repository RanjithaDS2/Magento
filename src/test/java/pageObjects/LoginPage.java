package pageObjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends basePage {

	
	WebDriver driver;
	
	//constructor
	public LoginPage (WebDriver driver)
	{
		super(driver);
	}
	
	//locators
	
	@FindBy(xpath="//input[@id=\"email\"]")
	public  WebElement emailLogin;
	
	
	@FindBy(xpath="//input[@title=\"Password\"]")
	 public WebElement passwordLogin;
	 
	
	@FindBy(xpath="//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]")
	 public WebElement  signInLoginPage;
	
	
	@FindBy(xpath="//strong[contains(text(),\"Registered Customers\")]")
	 WebElement  customerLoginTextDisplay;
	
	
	@FindBy(xpath="//a[@class='action remind']//span[contains(text(),'Forgot Your Password?')]")
	 WebElement  forgotPaswordLink;
	
	
	@FindBy(xpath="//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	 WebElement  failureError;
	
	
	@FindBy(xpath="//div[@class='panel header']//span[@class='logged-in'][normalize-space()='Welcome, ranjitha s!']")
	public WebElement  welcometext;
	
	@FindBy(xpath="//div[@class='panel wrapper']//li[@class='customer-welcome']")
	public WebElement  welcomeButton; 
	
	@FindBy(xpath="//li[@class='customer-welcome active']//a[normalize-space()='Sign Out']")
	public WebElement  logoutButton;
	
	
	 //Action Methods
	  
	  public void passEmail(String user)
	  {
		  emailLogin.sendKeys(user);
	  }
	  
	
	  //need to click on it before sending the email value so creating this method
	  public void clickEamilField()
	  {
		  emailLogin.click();
	  }
	  
	  
	  public void passPassword(String pass)
	  {
		  passwordLogin.sendKeys(pass);
	  }
	
	  
	  ////need to click on it before sending the password value so creating this method
	  public void clickPasswordField()
	  {
		  passwordLogin.click();
	  }
	  
	  
	  
	  public void clickSignUp()
	  {
		  signInLoginPage.click();
	  }
	
	  
	  
	  public boolean  getTextCustomerLogin()
	  {
		  boolean diplayed=customerLoginTextDisplay.isDisplayed();
		  return diplayed;
	  }
	
	  
	  public String  getErrorValue()
	  {
		  
		  String failureErrorMessage=failureError.getText();
		  return failureErrorMessage;
	  }
	  
	  public void clickWelcomeText()
	  {
		  welcomeButton.click();
	  }
	  
	  
	  public boolean isWelcomeTextDisplayed()
	  {
		return  welcometext.isDisplayed();
		  
	  }
	  
	  
	  public boolean isLogoutDisplayed()
	  {
		return  logoutButton.isDisplayed();
		  
	  }
	  
	  public void clickLogoutButton()
	  {
		  logoutButton.click();
	  }
	  
	  
	  
	  
	  public String forgotPasswordHyperlink() {
	        try 
	        {  
	              //get attribute will fetch "href(link)"
	                String actualUrl = forgotPaswordLink.getAttribute("href");
	                System.out.println("Fetched URL: " + actualUrl);
	                return actualUrl;
	        }
	        catch (NoSuchElementException e)
	        {
	            System.out.println("Element not found: ");
	            return ("its failed to fecth!");
	        }
		       
		}
	
}
