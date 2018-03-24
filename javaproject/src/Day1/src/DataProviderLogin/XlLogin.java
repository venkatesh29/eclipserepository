package DataProviderLogin;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class XlLogin {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("https://www.redbus.in/");
		

	    driver.manage().window().maximize();
	   // Thread.sleep(100);
	    
		driver.findElement(By.xpath(".//*[@id='src']")).sendKeys("B");
		Thread.sleep(100);
		
		List<WebElement> FROM=driver.findElements(By.xpath("//ul[@class='autoFill']/li"));		
		
			for(int i=0;i<FROM.size();i++) {
			String source=FROM.get(i).getText();
			if(source.equalsIgnoreCase("Bangalore")) {				
				WebElement fromelement=FROM.get(i);
				//Thread.sleep(100);
				FROM.get(i).click();
				break;
				}
			}
				
			driver.findElement(By.xpath("//input[@id='dest'][@data-message='Please enter a destination city']")).sendKeys("H");
			Thread.sleep(500);
		
	        List<WebElement> TO=driver.findElements(By.xpath("//ul[@class='autoFill']/li"));	
	
			for(int j=0;j<TO.size();j++) {
				String dest=TO.get(j).getText();
				if(dest.equalsIgnoreCase("Hyderabad")) {
					//Thread.sleep(300);
					 WebElement elementtoclick=TO.get(j);
			
					 elementtoclick.click();
				break;
				}}	
			
			Thread.sleep(500);
			driver.findElement(By.xpath("html/body/div[6]/table/tbody/tr[7]/td[3]")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("//button[@id='search_btn']")).click();
			
			int sortedbusessize=0;
			String currenturl=driver.getCurrentUrl();
			if(currenturl.equalsIgnoreCase("https://www.redbus.in/search?fromCityName=Bangalore&fromCityId=122&toCityName=Hyderabad&toCityId=124&onward=28-Feb-2018&opId=0&busType=Any#")) {
				sortedbusessize=driver.findElements(By.xpath("//*[@class='clearfix main-body bus-tupple']")).size();
			}		

			JavascriptExecutor js = (JavascriptExecutor) driver;
			int k=1;
			WebElement tofind=driver.findElement(By.xpath(".//*[@id='rh_footer']/div/div/div/div/div[4]/span[2]"));
			while(tofind.isDisplayed()==false) {
				//Thread.sleep(1000);
				js.executeScript("window.scrollBy(0,150)");
				String busname=driver.findElement(By.xpath("((//*[@class='clearfix main-body bus-tupple'])["+k+"]/div/div)[1]")).getText();
				String busstatus=driver.findElement(By.xpath("((//*[@class='clearfix main-body bus-tupple'])["+k+"]/div/div)[2]")).getText();
				System.out.println(k+" : "+busname+"     "+busstatus);
				k++;
			}			
	}
}
