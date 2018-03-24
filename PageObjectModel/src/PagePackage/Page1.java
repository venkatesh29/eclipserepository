package PagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Page1 {
	
	WebDriver driver;
	public Page1(WebDriver driver) {
		this.driver=driver;
	}
    public void facebookinit() {		
	driver=new FirefoxDriver();
	driver.get("https://www.facebook.com/");
	driver.close();
    }
}
