package com.automation.Test.webAutomation.webActions;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class links {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
        WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.asos.com/");
		
		// turn this to find by object
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("Total links are "+links.size());
		// this calculate the total amounts of links on the site 
		
		
		for(int i=0;i<links.size();i++)
		{
			// this prints each webelements out by getthing each element link
			WebElement ele= links.get(i);
			String url=ele.getAttribute("href");
			
			verifyLinkActive(url);
			
		}
		 driver.close();
	}
	
	
	public static void verifyLinkActive(String linkUrl)
	{
        try 
        {
        	// instantiate the url method
           URL url = new URL(linkUrl);
           
        	// call the conection method
           HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
           
           //use the connection property 
           httpURLConnect.setConnectTimeout(5000);
           // connect to the application 
           httpURLConnect.connect();
           
           // get http response 
           if(httpURLConnect.getResponseCode()==200)
           {
               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
            }
          if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
           {
               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
            }
        } catch (Exception e) {
           
        }
    } 
	
	

}
