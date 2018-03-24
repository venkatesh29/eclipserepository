package DataProviderTest;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider {

	
//	    @DataProvider
//	    public String[][] loginData(){
//		String[][] data1 = {{"username1","password1"},{"username2","password2"}};
//		return data1;}
//	
//		@DataProvider
//		public String[][] loginData1(){
//			String[][] data2 = {{"username3","password3"},{"username4","password4"}};
//			return data2;}
//		
//	@Test(dataProvider = "loginData",priority=1)
//	public void TestLoginWithDataProvider1(String username,String password) throws InterruptedException{
//        
//		System.out.println(username+" "+password);
//	}
//	
//	@Test(dataProvider = "loginData1",priority=2)
//	public void TestLoginWithDataProvider2(String username,String password) throws InterruptedException{
//        
//		System.out.println(username+" "+password);
//	}
	
	@Test
	public void windowhandling() {
		WebDriver driver;
		
		driver=new FirefoxDriver();
		
		driver.get("https://www.naukri.com/");
		String Parent_Window = driver.getWindowHandle();
		
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String currentWindowHandle : allWindowHandles) {
		
			
			if (!currentWindowHandle.equals(Parent_Window)) {
				 driver.switchTo().window(currentWindowHandle);
				driver.close();
		     	}
		}
		
		
		
		
		
		
	}
	
}
