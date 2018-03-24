package TestPackage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class NewTest1 extends NewTest {
	  @Test
	  public void f() {
		  driver=new FirefoxDriver();
		  driver.get("https://www.facebook.com/");
		  
		  File SrcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  
		 // FileUtils.copyFile(SrcFile, "c://test.png");
		  try {
			FileUtils.copyFile(SrcFile, new File("E:\\SeleniumLab\\TestProject\\evidence\\test.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
}
