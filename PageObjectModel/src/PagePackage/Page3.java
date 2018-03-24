package PagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Page3 {
	WebDriver driver;
	
	public Page3(WebDriver driver) {
		this.driver=driver;
	}
	
    public void hdfcbankinit() {
	driver=new FirefoxDriver();
	driver.get("https://www.hdfcbank.com/");
	driver.close();
    }
}
