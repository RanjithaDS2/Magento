package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import utilities.ReadConfig;

public class BaseClass {

	public Logger logger;
	public static WebDriver driver;

	ReadConfig rc = new ReadConfig();

	public String baseURL = rc.getValue("baseUrl");
	public String email = rc.getValue("emailValue");
	public String password = rc.getValue("passwordValue");
	public String inValidEmail = rc.getValue("invalidEmail");
	public String inValidPassword = rc.getValue("invalidPassword");
	public String validFailureError = rc.getValue("validError");
	public String firstName = rc.getValue("firstname");
	public String lastName = rc.getValue("lastname");
	public String companyName = rc.getValue("company");
	public String streetaddressName = rc.getValue("streetaddress");
	public String cityName = rc.getValue("city");
	public String phoneNumber = rc.getValue("phonenumber");
	public String stateName = rc.getValue("state");
	public String zip = rc.getValue("zipValue");
	public String signInURL = rc.getValue("signInUrl");

	@BeforeClass(groups = { "sanity", "regression" })
	@Parameters({ "os", "browser" })
	public void setup(String os, String br) throws IOException

	{

		switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid Browser  name");
			return;

		}
		logger = LogManager.getLogger(this.getClass());

		driver.get(baseURL);
		driver.manage().window().maximize();

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-label='store logo']//img")));

	}
	
	
	
	
	@AfterClass(groups = { "sanity", "regression" })
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			logger.info("Driver tear down complete ...");
		}
	}
	
	
	
	

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;

	}

	
	public void waitForElementToBeVisible(WebElement element, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	

	public void waitForElementToBeClickable(WebElement element, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	
	public void waitForPageToLoad(int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
	}
	
	
	public String getText(WebElement element) {
	    String value = element.getText();
	    return value;
	}

	// common javaScriptExecutor for all pages

	public boolean javaScriptClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			// Scroll to the specified element
			js.executeScript("arguments[0].scrollIntoView(true);", element);

			// Attempt to click on the element
			element.click();

			// Return true if successful
			return true;
		} catch (Exception e) {
			// Handle any exceptions and return false
			System.out.println("Exception occurred: " + e.getMessage());
			return false;
		}
		
	
	}

	
}