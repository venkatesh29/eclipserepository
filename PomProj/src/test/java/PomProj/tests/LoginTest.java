package PomProj.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import PomProj.util.ExtentManager;

public class LoginTest {
@Test
public void testLogin() {
	
	ExtentReports ereport=ExtentManager.getInstance();
	ExtentTest etest=ereport.startTest("LoginTest");
	etest.log(LogStatus.INFO, "LoginTest Started");
	
	
}

}
