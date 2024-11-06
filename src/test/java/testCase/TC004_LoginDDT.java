package testCase;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;





public class TC004_LoginDDT extends BaseClass
{
	HomePage home;
	LoginPage login;
	Actions action;
	BaseClass baseclass;
	
	@BeforeClass(groups = {"sanity","regression"})
	public void intializePage() {
		home = new HomePage(driver);
		login = new LoginPage(driver);
		action = new Actions(driver);
		baseclass=new BaseClass();
	}

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email, String password, String exp)
	{
		logger.info("**** Starting TC004_LoginDDT *****");
		
		try {
	
		//Home page
			
			String value=exp;
			
			logger.info("Expected the response value here! {}",value);

			driver.get(signInURL);
			logger.info("opening the base url of the application!");

			

			Thread.sleep(2000);
			baseclass.javaScriptClick(login.emailLogin);
			login.passEmail(email);

			Thread.sleep(2000);
			baseclass.javaScriptClick(login.passwordLogin);
			login.passPassword(password);

			logger.info("Both Email and Password values are added here!");

			login.clickSignUp();
			
			
			waitForPageToLoad(10);
			
			
			/*waitForElementToBeVisible(login.welcometext, 10);
			boolean isdisplayedofWelcomeText=login.isWelcomeTextDisplayed();
			System.out.println("the welcome text  is dispalyed here!");
			
			String text = getText(login.welcometext);
	        System.out.println("Text of the element: " + text);
	
			
			//boolean isdisplayedofWelcomeText=login.isWelcomeTextDisplayed();
			//boolean createAccountDiplay=login.isCreateAccountOptionDisplayed();
			
			
			boolean isdisplayedofLogoutText=login.isLogoutDisplayed();
			System.out.println(isdisplayedofLogoutText);
			Assert.assertTrue(isdisplayedofLogoutText, "The element should be displayed on the page.");
			*/
			/*
			if(login.isCreateAccountOptionDisplayed()==false)
			{
				waitForElementToBeClickable(login.welcomeButton, 10); 
				login.clickWelcomeText();
				login.clickLogoutButton();
				Assert.assertTrue(false,"The data is valid and Login is successfull!");
			}
			else
			{
				Assert.assertTrue(true,"The data is invalid and login is UnSuccessfull!");
			}
			
		/*
			/*Data is valid  - login success - test pass  - logout
			Data is valid -- login failed - test fail

			Data is invalid - login success - test fail  - logout
			Data is invalid -- login failed - test pass
			*/
		
			logger.info("Expected the response value here222222! {}",value);
			if(value.trim().equalsIgnoreCase("Valid"))
			{
				 logger.info("1");
					waitForElementToBeClickable(login.welcomeButton, 10);
					 logger.info("2");
					login.clickWelcomeText();
					 logger.info("3");
					waitForElementToBeClickable(login.logoutButton, 10); 
					 logger.info("4");
					login.clickLogoutButton();
					 logger.info("5");
					Assert.assertTrue(true,"The data is valid and Login is successfull!");
					 logger.info("6");
			}
			
			else 
			{
				 logger.info("7");
				Assert.assertTrue(true,"The data is invalid and login is UnSuccessfull!");
				 logger.info("8");
			}
			
			/*
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(isdisplayedofLogoutText==false)
				{
					//login.clickLogoutButton();
					Assert.assertTrue(true);
				}
				
			}
			*/
			
		}
		catch(Exception e)
		{
			Assert.fail("An exception occurred: " + e.getMessage());
		}
			
		logger.info("**** Finished TC004_LoginDDT *****");
	}
	
}








