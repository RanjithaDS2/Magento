package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeClass;

import testBase.BaseClass;

public class SearchPage extends basePage {

	public WebDriver driver;
	
	HomePage home;
	LoginPage login;
	Actions action;
	BaseClass baseclass;
	
	
	//Constructor
	public SearchPage(WebDriver driver)
	{
		super(driver);
		home=new HomePage(driver);
		login=new LoginPage(driver);
		action=new Actions(driver);
		baseclass=new BaseClass();
	}
	
	
//Locators
	 @FindBy(xpath="//input[@id=\"search\"]")
	  public WebElement searchBox;
	  
	  @FindBy(xpath="//span[contains(text(),'Women')]")
	  public WebElement womenOptions;
	  

	  
	  @FindBy(xpath="//a[@id=\"ui-id-9\"]//span[contains(text(),\"Tops\")]")
	  public  WebElement topsOption;
	  
	
	  @FindBy(xpath="//a[@id=\"ui-id-11\"]/span[contains(text(),\"Jackets\")]")
	  public  WebElement jacketsOption; 
	  
	
	  @FindBy(xpath="//li[@class=\"item product product-item\"]//a[contains(text(),\"Olivia 1/4 Zip Light Jacket \")]")
	  public  WebElement firstProduct;
	  
	  @FindBy(xpath="//div[@id='option-label-size-143-item-167']")
	  public  WebElement sizeProduct;
	
	  
	  @FindBy(xpath="//div[@id='option-label-color-93-item-50']")
	  public  WebElement colorProduct;
	
	  @FindBy(xpath="//span[@id=\"product-price-1396\"]")
	  public  WebElement priceProduct;
	  
	  @FindBy(xpath="//button[@title=\"Add to Cart\"]")
	  public  WebElement addCartButton;
	
	  @FindBy(xpath="//a[@class='action showcart']")
	  public  WebElement inCart;
	
	  @FindBy(xpath="//button[@id=\"top-cart-btn-checkout\"]")
	  public  WebElement proceedCartButton;
	  
	
	  
	  
	  //Action methods
	  public void clickSearchOption()
	  {
		  searchBox.click();
	  }
	  
	  
	  public void clickSearchOption(String value)
	  {
		  searchBox.sendKeys(value);
	  }
	  
	  public void clickWomenOption()
	  {
		  womenOptions.click();
	  }
	  
	  public void loginTestAllMethods() throws InterruptedException
	  {
		  action.moveToElement(home.signINLink).perform();
		  home.clikSignIn();	
		  Thread.sleep(2000);
		  login.passEmail(baseclass.email);
		  Thread.sleep(2000);
		  login.passPassword(baseclass.password);
		  Thread.sleep(2000);
		  login.clickSignUp();
		  
	  }
	  
	  
	  public void clickTopsOption()
	  {
		  topsOption.click();
	  }
	  
	  
	  public void clickjacketsOption()
	  {
		  jacketsOption.click();
	  }
	  
	  
	  public void selectFirstOption()
	  {
		  firstProduct.click();
	  }
	  
	  public void selectSize()
	  {
		  sizeProduct.click();
	  }
	  
	  
	  public void selectColor()
	  {
		  colorProduct.click();
	  }
	  
	  public String  selectPrice()
	  {
		  String productPrize=priceProduct.getText();
		  return productPrize;
	  }
	  
	  public void clickAddToCart()
	  {
		  addCartButton.click();
	  }
	  
	  
	  public void clickToCart()
	  {
		  inCart.click();
	  }
	  
	  
	  public void clickProceedToCart()
	  {
		  proceedCartButton.click();
	  }
	  
	  
}
