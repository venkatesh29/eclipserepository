package ddfPack.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ddfPack.util.ExtentManager;
import ddfPack.util.MyXLSReader;

public class BaseTest {
	
	  public Properties prop = null;	
	  public WebDriver driver = null;
	  public ExtentReports eReport = ExtentManager.getInstance();
	  public ExtentTest eTest;
	 

	  //Initialization
	  public void initialise(){
		  
		  if(prop==null){
				
				prop = new Properties();
				
				File projectConfigFile = new File("src\\test\\resources\\projectconfig.properties");
				
				FileInputStream fis = null;
				
				try {
					
					 fis = new FileInputStream(projectConfigFile);
					 prop.load(fis);
					
				} catch (Exception e) {
			
					e.printStackTrace();
					
				}
				
			}
		  
	  }
	  
	  //Open Browser
	  public void openBrowser(String browserType){
		  
		  eTest.log(LogStatus.INFO, "Opening Browser : "+browserType);
		  
		  if(browserType.equalsIgnoreCase("firefox")) {
			  
			 driver = new FirefoxDriver();
			  		   
		  }else if(browserType.equalsIgnoreCase("chrome")) {
			  
			  System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));
			  
			  driver = new ChromeDriver();
			  
		  }else if(browserType.equalsIgnoreCase("ie")) {
			  
			  System.setProperty("webdriver.ie.driver", prop.getProperty("ieDriverPath"));
			  
			  driver = new InternetExplorerDriver();

		  }
		  
		  eTest.log(LogStatus.INFO, "Browser opened Successfully "+browserType);
		  
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  
	  }
	  
	  //Open application
	  public void navigate(String urlKey) {
		  
		  driver.get(prop.getProperty(urlKey));
		  eTest.log(LogStatus.INFO, "Navigated to "+prop.getProperty(urlKey));
	 
	  }
	  
	  //Login into Application
	  public boolean doLogin(String Username,String Password) {
		  
		  click("LoginLink_classname");
		  type("LoginUsername_id",Username);
		  type("LoginPassword_id",Password);
		  click("SignInButton_id");
		  if(isElementPresent("CRMOption_cssselector")) {
			  
			  return true;
		  
		  }else {
			  
			  return false;
		 
		  }
		  
	  }
	  
	  //Clicking UI element
	  public void click(String locatorKey) {
		  	
		 eTest.log(LogStatus.INFO, "Clicking on "+locatorKey);
		 WebElement element =  getElement(locatorKey);
		 element.click();
		 eTest.log(LogStatus.INFO, "Successfully clicked on "+locatorKey);
		 
	  }
	  
	  //Intakes locator key and return WebElement based on the locator type
	  public WebElement getElement(String locatorKey) {
		  
		  WebElement element = null;
		  
		  try {
			  
		  
			  if(locatorKey.endsWith("_id")) {
				  
				  element = driver.findElement(By.id(prop.getProperty(locatorKey)));
				  
			  }else if(locatorKey.endsWith("_name")) {
				  
				  element = driver.findElement(By.name(prop.getProperty(locatorKey)));
				  
			  }else if(locatorKey.endsWith("_classname")) {
				  
				  element = driver.findElement(By.className(prop.getProperty(locatorKey)));
				  
			  }else if(locatorKey.endsWith("_cssselector")) {
				  
				  element = driver.findElement(By.cssSelector(prop.getProperty(locatorKey)));
				  
			  }else if(locatorKey.endsWith("_xpath")) {
				  
				  element = driver.findElement(By.xpath(prop.getProperty(locatorKey)));
				  
			  }else {
				  
				  reportFail("The provided Locator - "+locatorKey+" is not found");
				  
			  }
			  
		  }catch(Exception e) {
			  
			  reportFail(e.getMessage());
			  
		  }
		  
		  return element;
		  
	  }
	  
	  //Types text into text box fields
	  public void type(String locatorKey,String data) {
		  
		 eTest.log(LogStatus.INFO, "Typing text into "+locatorKey+" with data "+data);
		 WebElement element = getElement(locatorKey);
		 element.sendKeys(data);
		 eTest.log(LogStatus.INFO, "Successfully typed text into "+locatorKey+" with data "+data);
			  
	  }
	  
	  //Finding whether the required element is available on the page
	  public boolean isElementPresent(String locatorKey) {
		  
		  WebElement element = getElement(locatorKey);
		  
		  boolean presentStatus = element.isDisplayed();
		  
		  return presentStatus;
		  
	  }
	  
	  //This method will be called when the test is passed
	  public void reportPass(String messsage) {
		  
		  eTest.log(LogStatus.PASS, messsage);
		  
	  }
	  
	  //This method will be called when the test is failed
	  public void reportFail(String message) {
		  
		  takeScreenshot();
		  eTest.log(LogStatus.FAIL, message);
		  Assert.fail(message);
		  
	  }
	  
	  //Will be called to take screenshots
	  public void takeScreenshot(){
			
			Date d=new Date();
			String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scrFile, new File("screenshots//"+screenshotFile));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//put screenshot file in reports
			eTest.log(LogStatus.INFO,"Screenshot-> "+ eTest.addScreenCapture(System.getProperty("user.dir")+"//screenshots//"+screenshotFile));
			
		}
	  

}