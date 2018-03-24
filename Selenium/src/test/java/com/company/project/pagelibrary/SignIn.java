package com.company.project.pagelibrary;


import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SignIn {
	WebDriver driver;
	static Logger log=Logger.getLogger(SignIn.class.getName());
	By signIn=By.xpath(".//*[@id='header']/div[2]/div/div/nav/div[1]/a");
	By createAccEmailAddr=By.xpath(".//*[@id='email_create']");
	By Email=By.xpath(".//*[@id='email']");
	
	public SignIn(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public void clickonSignIn() {
		log.info("clicking on signIn link");
		driver.findElement(signIn).click();
	}
	
	public void type(String email) {
		log.info("type into");
		driver.findElement(Email).sendKeys(email);
		
	}
	
	public void dologin() {
		  
		 type("villa.venkatesh@gmail.com");	

}}
