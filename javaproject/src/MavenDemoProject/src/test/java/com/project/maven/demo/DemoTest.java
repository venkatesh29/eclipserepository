package com.project.maven.demo;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DemoTest {
  @Test
  public void f() {
	  FirefoxDriver driver=new FirefoxDriver();
	  driver.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/2.53.1");
  }
}
