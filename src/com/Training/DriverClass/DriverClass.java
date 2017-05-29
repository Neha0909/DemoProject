package com.Training.DriverClass;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.Training.XLReader.XlReader;

import PropertyFileReader.PropertyReader;

public class DriverClass {

	private static WebDriver driver;
	private static String BrowserToSelect = "";
	
	public static void LaunchDriver (String BrowserToSelect){
	String URL = "https://mywipro.wipro.com";
	
		try{	   
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
		driver.navigate().to(URL);
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			driver.close();
			driver.quit();
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		
		XlReader readXl=new XlReader();
		
		System.out.println("--Inside Xl reader method --");
		
		List<String> ArrayList=new ArrayList<String>();
		ArrayList.addAll(readXl.getRows());
	    Iterator<String> iterator = ArrayList.iterator();
	     
	     while (iterator.hasNext()) {
	         String ArrayIndex = iterator.next();
	         if(ArrayIndex.equals("Y")){
	        	 
	        	 BrowserToSelect = iterator.next();
	        	LaunchDriver(BrowserToSelect);
	         }		
	}
	}
}
