/**
 * 
 */
package com.JB.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.JB.PageObjects.LoginPage;
import com.JB.Utilities.BrowserFactory;
import com.JB.Utilities.FileReader;
import com.JB.Utilities.Log;
import com.JB.Utilities.commonUtils;

/**
 * @author jeyaram.baba
 *
 */
public class VerifyLoginPage 
extends BrowserFactory
{
	
	//public BrowserFactory BrowserFact;
	// WebDriver driver;
	String URL="";
	String username="";
	String password="";
	//BrowserFactory BrowserFact = new BrowserFactory();
	FileReader FR = new FileReader();
	
	
	static commonUtils Util = new commonUtils();
	Log testLog = new Log();
	
	
  @BeforeTest(description = "Opening Given Browser with Credentials")
  @Parameters("parallelExecution")
	public void OpenBrowser(String Execution) 
	  {  
	  System.out.println("Parameter Value "+Execution);
		  Util.GetCurrentDateandTime();
		  String App = FR.PropertyFileReader("application");
		  String Browser = FR.PropertyFileReader("browser");
		  
		  try {
			URL = FR.XLReader(App,0,1);
			username = FR.XLReader(App,1,1);
			password = FR.XLReader(App,2,1);
		  } 
		  catch (IOException e) 
		  {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  driver = OpenBrowser(URL, Browser);
	  }
	  
@Test
public void LoginTest()
	{
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.type_username(username);
		testLog.info("Entered User Name");
		login.type_password(password);
		testLog.info("Entered Password");
		login.click_Loginbutton();
		testLog.info("Clicked on Submit Button");
	}

@AfterTest
public static void GetScreenshot()
	{
	try {
		Util.TakeScreenShot(driver);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

@AfterClass
public void CloseBrowser()
{
	driver.quit();
}
}
