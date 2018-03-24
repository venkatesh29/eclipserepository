package PomProj.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentReports;

import PomProj.util.ExtentManager;

public class LoginPage {
@FindBy(id="lid")
public WebElement emailField;

@FindBy(id="pwd")
public WebElement passwordField;

@FindBy(xpath=".//*[@id='signin_submit']")
public WebElement submit;

public void doLogin(String Username,String Password) {
	
	
}

}
