package TestPackage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class NewTest {
	public WebDriver driver;
  @Test
  public void f() {
	 int a=5;
	 int x;
	 try {
	x= a/0;}catch(ArrayOutofBoundException e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	 
	 System.out.println("fdfdfdfdfdf");
  }
}
