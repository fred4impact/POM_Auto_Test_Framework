/**
 * 
 */
package com.automation.Test.webAutomation.landingpage;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.Test.webAutomation.testBase.TestBase;
import com.automation.Test.webAutomation.webActions.landingPage;

/**
 * @author bilarn
 *TestCase for the home page to verify invalid login users with invalid credentials
 */
public class TC01_verifyinvalidLoginUser extends TestBase{
	
	
	 public static final Logger log = Logger.getLogger(TC01_verifyinvalidLoginUser.class.getName());

     //WebDriver driver;
     landingPage landpage;
     
     
	// sample setup before test start 
	@BeforeTest
	 public void setUp() {
		log.info("==== setting up our brwoser=========");
		setupBrowser(); // call the set up browser here 
		
//		driver = new ChromeDriver();
//		driver.get("https://www.gumtree.com");
//		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 }
	 

	 

	 // sample my test
	@Test
	 public void verifyinvalidLoginUser() {
		
	    landpage = new landingPage(driver);
	    log.info("====== starting Test =========");
	    landpage.loginUser("run.soemthing@gmail.com", "000654");
	    //Assert.assertEquals(landpage.invalidinfo(), "Fail authentication");
		log.info("====== Finish verification of te user s=========");
		
//      driver.findElement(By.className("header-nav-link")).click();
//      driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("run.soemthing@gmail.com");
//	    driver.findElement(By.xpath("//*[@id=\"fld-password\"]")).sendKeys("000654");
//	    driver.findElement(By.tagName("button")).submit();
//	 
//	    String checkasert = driver.findElement(By.xpath("//*[@id=\"username_elementnotice\"]/li")).getText();
//	    Assert.assertEquals(checkasert, "Your username or password is incorrect");		  
	  
	 }
	 
	
	 
	 // sample teardown to close the browser after class run
	 @AfterClass
	 public void endTest() {
        log.info("closing the brwoser");
		 driver.quit();
		 
	 }
}
