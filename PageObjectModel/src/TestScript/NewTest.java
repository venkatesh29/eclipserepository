package TestScript;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import PagePackage.Page1;
import PagePackage.Page2;
import PagePackage.Page3;

public class NewTest {  
	  WebDriver driver;
	  Page1 p1=new Page1(driver);
	  Page2 p2=new Page2(driver);
	  Page3 p3=new Page3(driver);
  @Test
  public void f() {
	 
	 p1.facebookinit();	 	 
	 p2.redbusinit();
	 p3.hdfcbankinit();
	  
	  
  }
}
