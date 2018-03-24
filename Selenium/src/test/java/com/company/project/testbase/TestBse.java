package com.company.project.testbase;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBse {
	public static Properties Repository=new Properties();
	public File f;
	public FileInputStream fis;
	public WebDriver driver;	
	
	public void init() throws IOException {		
		loadProperties();		
		selectBrowser(Repository.getProperty("browser"));
		driver.get(Repository.getProperty("url"));
		
	}
	
	public void loadProperties() throws IOException {
		f=new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\company\\project\\config\\config.properties");
		fis=new FileInputStream(f);
		Repository.load(fis);
		
	}
	
	public void selectBrowser(String browser) {
		if (browser.equals("Firefox") || browser.equals("FIREFOX")){
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
		
	}}
	
	public void closebrowser() {
		driver.quit();}
	

}
