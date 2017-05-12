package com.Training.DriverClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import PropertyFileReader.PropertyReader;

public class DriverClass {

	public static WebDriver driver;
	PropertyReader prop = new PropertyReader();
	public static String URL="";
//	public DriverClass(){
/*
	String BrowserToSelect	= prop.PropertyReader("Browser");
	System.out.println(BrowserToSelect);
		if(BrowserToSelect.equalsIgnoreCase("Firefox")){
		driver = new FirefoxDriver();
		} else if(BrowserToSelect.equalsIgnoreCase("Chrome")){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ne321427\\Downloads\\Selenium files\\Selenium files\\BrowserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		} else if(BrowserToSelect.equalsIgnoreCase("IE")){
		System.setProperty("webdriver.ie.driver","C:\\Users\\ne321427\\Downloads\\Selenium files\\Selenium files\\BrowserDrivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		}
		URL = prop.PropertyReader("Url");
		
		driver.navigate().to(URL);
	}
	
	*/
	public static void main(String[] args) {
		
		DriverClass d = new DriverClass();
	}

}
