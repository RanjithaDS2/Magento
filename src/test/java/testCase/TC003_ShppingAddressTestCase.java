package testCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;
import pageObjects.shippingAddressPage;
import testBase.BaseClass;

public class TC003_ShppingAddressTestCase extends BaseClass{
	
	SearchPage search;
	HomePage home;
	LoginPage login;
	Actions action;
    shippingAddressPage shipping;
    BaseClass baseclass;

	
	@BeforeClass(groups={"sanity","Regression"})
	public void intializePage3()
	{
		home=new HomePage(driver);
		login=new LoginPage(driver);
		search=new SearchPage(driver);
		action=new Actions(driver);
		shipping=new shippingAddressPage(driver);
		 baseclass=new BaseClass();
	}
	
	@Test(priority=6, testName="Validate the Shipping Address functionality after the product added to the cart ",groups={"sanity","Regression"}, retryAnalyzer = analyzer.RetryAnalyzer.class)
	public void shippingValidation1() throws InterruptedException
	{
		/*
		 * Open the url
		 * click on the signUp Button
		 * enter valid Email
		 * enter valid Password
		 * click on signIn button
		 * move to Women option
		 * move to Tops option
		 * click on Jocket option
		 * click on first product
		 * select size
		 * select color
		 * add the product to Cart
		 * click on proceed to cart
		 * 
		 */

		

	shipping.loginTestAllMethods2();
		logger.info("User is successfully addednthe product in yo cart!");
		
		
		
		
		Thread.sleep(2000);
		baseclass.javaScriptClick(shipping.company);
		shipping.passCompany(companyName);
		
		baseclass.javaScriptClick(shipping.streetAddress);
		shipping.passAddress(streetaddressName);
		
		
		baseclass.javaScriptClick(shipping.city);
		shipping.passCity(cityName);
		
		
		shipping.passZip(zip);
		
		Select s=new Select(shipping.country);
		s.selectByVisibleText("India");
		
		Select s2=new Select(shipping.state);
		s2.selectByVisibleText("Karnataka");
	
	
		shipping.passPhoneNumber(phoneNumber);
		
		Thread.sleep(5000);
		shipping.clickRadio();
		
		
		//baseclass.javaScriptClick(shipping.next);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",shipping.next);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),\"Next\")]/parent::button")));
		 
		 Thread.sleep(2000);
		// shipping.next.click();
		 shipping.clickNext();
				
	}
	
	//@Test(priority=1, testName="Validate the Shipping Address functionality after the product added to the cart ",groups={"sanity","Regression"})
	
	

}
