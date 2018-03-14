/**
 * 
 */
package com.automation.Test.webAutomation.testBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author bilarn
 * In this class i store my my browser factory so i could call the methods and you will have to extend this Testbase Class in your testcase 
 */
public class TestBase {
    
	// create new instance of logger called log 
     public static final Logger log = Logger.getLogger(TestBase.class.getName());
	
	
	public WebDriver driver;  // call the driver interface here 
	String url = "https://www.gumtree.com";
	String browser = "chrome"; // type of browser we aer using 
	
	
	public void setupBrowser()
	{
	     chooseBrowser(browser); // call choose browser method
		 setUrl(url); // call setUrl method
		 String log4jConfPath = "log4j.properties"; // here i set the directory to log4J
		 PropertyConfigurator.configure(log4jConfPath); // here we configure the log4j
	}
	
	
	public void chooseBrowser(String browser) {
		
		// if it's chrome browser  instantiate a new chromebrowser this work for all
		if(browser.equalsIgnoreCase("chrome")) {
			log.info("=========create the object of browser=========");
			driver = new ChromeDriver();
		}
			
	}
	
	// this is the method to set out url, maximize window and set the timeout 
	public void setUrl(String url) {
		log.info("=========navigating to  url=========");
		driver.get(url);// get the url string 
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); // set the timeout 
	}
	
}
