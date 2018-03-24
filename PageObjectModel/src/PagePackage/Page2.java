package PagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Page2 {
	WebDriver driver;
	public Page2(WebDriver driver) {
		this.driver=driver;
	}
    public void redbusinit() {
	
	
	driver=new FirefoxDriver();
	driver.get("https://www.redbus.com/");
	driver.close();
    }
}
