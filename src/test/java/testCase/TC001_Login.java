package testCase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC001_Login extends BaseClass {
	HomePage home;
	LoginPage login;
	Actions action;

	@BeforeClass(groups = {"sanity","regression"})
	public void intializePage() {
		home = new HomePage(driver);
		login = new LoginPage(driver);
		action = new Actions(driver);
	}

	// ***************done***************
	@Test(priority = 1, testName = "Validate logging into the Application using valid credentials", groups = "sanity")
	public void loginValidation1() throws InterruptedException {
		/*
		 * Open the url click on the signUp Button enter valid Email enter valid
		 * Password click on signIn button
		 */

		
		driver.get(signInURL);
		logger.info("opening the base url of the application!");

		//action.moveToElement(home.signINLink).perform();
		//home.clikSignIn();
		//logger.info("The SignIn button is clicked!");

		Thread.sleep(2000);

		login.clickEamilField();
		login.passEmail(email);

		Thread.sleep(2000);

		login.clickPasswordField();
		login.passPassword(password);

		logger.info("Both Email and Password values are added here!");

		login.clickSignUp();
		
		
		waitForPageToLoad(10);
		
		
		waitForElementToBeVisible(login.welcometext, 10);
		boolean isdisplayedofWelcomeText=login.isWelcomeTextDisplayed();
		System.out.println("the welcome text  is dispalyed here!");
		
		String text = getText(login.welcometext);
        System.out.println("Text of the element: " + text);
		
		
		
		waitForElementToBeClickable(login.welcomeButton, 10); 
		login.clickWelcomeText();
	
		
		
		boolean isdisplayedofLogoutText=login.isLogoutDisplayed();
		System.out.println(isdisplayedofLogoutText);
		Assert.assertTrue(isdisplayedofLogoutText, "The element should be displayed on the page.");
		System.out.println("the logout button is dispalyed here!----6");
		
		login.clickLogoutButton();

	}

	// **********done ********
	@Test(priority=2,testName="Validate logging into the Application using invalid credentials (i.e., valid Email and Invalid password)",groups="sanity")

	public void loginValidation2() throws InterruptedException {

		/*
		 * Open the url click on the signUp Button enter valid Email enter in-valid
		 * Password click on signIn button
		 */

		driver.get(signInURL);
		logger.info("opening the base url of the application!");

		//action.moveToElement(home.signINLink).perform();
		//home.clikSignIn();
		//logger.info("The SignIn button is clicked!");

		waitForPageToLoad(10);

		
		login.clickEamilField();
		login.passEmail(email);

		Thread.sleep(2000);

		login.clickPasswordField();
		login.passPassword(inValidPassword);

		logger.info("Both valid Email and invalid Password values are added here!");

		login.clickSignUp();

		String errorMessage = login.getErrorValue();
		Assert.assertEquals(errorMessage, validFailureError, "errordidnt display!");
		System.out.println(errorMessage);
		logger.info("Login got failed and error message logged due to invalid password!");

	}

	@Test(priority = 3, testName = "Validate logging into the Application using invalid credentials (i.e.InValid Email and Valid password)", groups = "regression")

	public void loginValidation3() throws InterruptedException {

		/*
		 * Open the url click on the signUp Button enter in-valid Email enter valid
		 * Password click on signIn button
		 */

		driver.get(signInURL);
		logger.info("opening the base url of the application!");

		//action.moveToElement(home.signINLink).perform();
		//home.clikSignIn();
		//logger.info("The SignIn button is clicked!");

		waitForPageToLoad(10);

		login.clickEamilField();
		login.passEmail(inValidEmail);

		Thread.sleep(2000);

		login.clickPasswordField();
		login.passPassword(password);

		logger.info("Both valid Email and invalid Password values are added here!");

		login.clickSignUp();

		String errorMessage = login.getErrorValue();
		Assert.assertEquals(errorMessage, validFailureError, "errordidnt display!");
		System.out.println(errorMessage);
		logger.info("Login got failed and error message logged due to invalid password!");

	}

	@Test(priority = 3, testName = "Validate logging into the Application using invalid credentials (i.e.InValid Email and InValid password)", groups = "regression")

	public void loginValidation4() throws InterruptedException {

		/*
		 * Open the url click on the signUp Button enter in-valid Email enter in-valid
		 * Password click on signIn button
		 */

		 driver.get(signInURL);
		logger.info("opening the base url of the application!");

		//action.moveToElement(home.signINLink).perform();
		//home.clikSignIn();
		//logger.info("The SignIn button is clicked!");

		waitForPageToLoad(10);

		login.clickEamilField();
		login.passEmail(inValidEmail);

		Thread.sleep(2000);

		login.clickPasswordField();
		login.passPassword(inValidPassword);

		logger.info("Both valid Email and invalid Password values are added here!");

		login.clickSignUp();

		String errorMessage = login.getErrorValue();
		Assert.assertEquals(errorMessage, validFailureError, "errordidnt display!");
		System.out.println(errorMessage);
		logger.info("Login got failed and error message logged due to invalid password!");

	}
}