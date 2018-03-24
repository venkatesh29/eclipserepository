package Autofillers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Autofillers {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("https://www.redbus.com/");
		Thread.sleep(300);
		
		driver.findElement(By.xpath(".//*[@id='go']")).click();
		driver.findElement(By.xpath(".//*[@id='src']")).sendKeys("B");
		
		Thread.sleep(300);
		List<WebElement> FROM=driver.findElements(By.xpath("//div[@class='autocomplete-suggestion']"));
		
		for(int i=0;i<FROM.size();i++) {
			String source=FROM.get(i).getText();
			System.out.println(source);			
//			if(source.equalsIgnoreCase("Bangalore")) {
//				FROM
//			}
		}

	}

}
