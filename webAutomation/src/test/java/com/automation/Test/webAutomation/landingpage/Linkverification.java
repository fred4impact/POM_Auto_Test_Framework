/**
 * 
 */
package com.automation.Test.webAutomation.landingpage;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author bilarn
 *
 */
public class Linkverification {
	
	
WebDriver driver;
	
	@BeforeTest
	public void OpenBrowser() {
    WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.indeed.co.uk/");
	
	}
	
	
	@Test
	public void TestLink() {
	List<WebElement> links=driver.findElements(By.tagName("a"));
    System.out.println("Total links are "+links.size());
				
	for(int i=0;i<links.size();i++)
	  {
			WebElement weblink= links.get(i);
		    String url = weblink.getAttribute("href");
		    verifyLinkActive(url);			
	  }
	
	
	}
	
	public void verifyLinkActive(String Linkurl){
		
		 try 
	        {
	           URL url = new URL(Linkurl);
	           
	           HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
	           
	           httpURLConnect.setConnectTimeout(3000);
	           
	           httpURLConnect.connect();
	           
	           if(httpURLConnect.getResponseCode()==200)
	           {
	               System.out.println(Linkurl+" - "+httpURLConnect.getResponseMessage());
	            }
	          if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
	           {
	               System.out.println(Linkurl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
	            }
	        } catch (Exception e) {
	           
	        }
		
	}
	
	
	
		
	
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	
	

}
