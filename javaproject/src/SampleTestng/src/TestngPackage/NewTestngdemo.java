package TestngPackage;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class NewTestngdemo {
  SoftAssert soft=new SoftAssert();
@Test(groups= {"sanity"})
  public void f() {
	 soft.assertTrue(3>5,"on fail");
  }
}
