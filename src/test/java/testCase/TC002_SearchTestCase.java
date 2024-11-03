package testCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC002_SearchTestCase extends BaseClass {

	SearchPage search;
	HomePage home;
	LoginPage login;
	Actions action;

	
	@BeforeClass(groups={"sanity","Regression"})
	public void intializePage2()
	{
		home=new HomePage(driver);
		login=new LoginPage(driver);
		search=new SearchPage(driver);
		action=new Actions(driver);
	}
	
	@Test(priority=5, testName="Validate logging into the Search Functionality of the Application",groups={"sanity","Regression"})
	public void searchValidation1() throws InterruptedException
	{
		/*
		 * Open the url
		 * click on the signUp Button
		 * enter valid Email
		 * enter valid Password
		 * click on signIn button
		 */

		

        search.loginTestAllMethods();
		logger.info("User is successfully logged in to application!");
		
		action.moveToElement(search.womenOptions).perform();
		logger.info("moving to women option!");
		
		
		
		action.moveToElement(search.topsOption).perform();
		logger.info("moving to tops option!");
		
		
		//search.clickTopsOption();
		//logger.info("click on tops option!");
		
		
		action.moveToElement(search.jacketsOption).perform();
		logger.info("moving to jackets option!");
		
		
		search.clickjacketsOption();
		logger.info("click on jacket option!");
		
		Thread.sleep(2000);
		search.selectFirstOption();
		logger.info("click on first product option!");
		
		search.selectSize();
		logger.info("selecting the size of the first product here!");
		
		search.selectColor();
		logger.info("selecting the color of the first product here!");
		
		String priceValueOfProduct=search.selectPrice();
		System.out.println(priceValueOfProduct);
		
		search.clickAddToCart();
		logger.info("clicking on the color of the first product here!");
		
		search.clickToCart();
		logger.info("clicking on the cart here!");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		WebElement element =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='top-cart-btn-checkout']")));
		element.click();
		//search.clickProceedToCart();
		logger.info("clicking on the proceedToCart here!");
		System.out.println("Finally the product is successfully added to cart and available in cart");
		
	}
		
	}
	

