package Itestliner;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//<listeners>
//<listener class-name="Itestliner.testnglistener.class"/>
//</listeners>

@Listeners(Itestliner.testnglistener.class)	
public class TestCases {
	public WebDriver driver;
	
	@Test		
	public void TestToFail() throws InterruptedException, IOException				
	{		
		
		
	    //System.out.println("This method to test fail");					
	    Assert.assertTrue(false);	
	 
	}
}
