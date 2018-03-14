/**
 * 
 */
package com.automation.Test.webAutomation.webActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.automation.Test.webAutomation.landingpage.TC01_verifyinvalidLoginUser;

/**
 * @author bilarn
 *we store our landing page objects in this class for  page factory  
 */

public class landingPage {
	
	public static final Logger log = Logger.getLogger(landingPage.class.getName());

	  WebDriver driver;  // inherit driver interface 
	  
	  @FindBy(className="header-nav-link")
	  WebElement Loginlink;
	  
	  @FindBy(xpath="//*[@id=\"email\"]")
	  WebElement email;
	
	  // here is another Techniques 
	  @FindBy(how=How.XPATH, using="//*[@id=\"fld-password\"]")
	  WebElement password;
	  
	  // here we find the login button 
	  @FindBy(how=How.TAG_NAME, using="button")
	  WebElement login;
	  
	  // these represent information u coudld get foe invalid incasae you want to use it with assertion 
	  @FindBy(how=How.LINK_TEXT, using="Please enter a valid email address.")
	  WebElement invalidinfo;
	  
	  // constructor // using page factory init
	  public landingPage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	  }
	  
	  
	  // here we design method to login to application
	  public void loginUser(String email, String password) {
		   Loginlink.click();
		   log.info("==== clicked the login/register link and the object is :-" +Loginlink.toString());
		   this.email.sendKeys(email);
		   log.info("==== enters the invalid email and the object is :-" +this.email.toString());
		   this.password.sendKeys(password);
		   log.info("==== enters invalid password and the object is :-" +this.password.toString());
		   login.submit();  
		   log.info("==== clicked the login/register link and the object is :-" +login.toString());
	  }
	  
	  
	  public String invalidinfo() {
		  log.info("==== verify the error message  :-" +invalidinfo.toString());
		 return  invalidinfo.getText(); // this returns the test from the xpath of the element that holds the info
	  }
	  
	  // make sure you dont write assertion in your page method use it in the test script 
}
