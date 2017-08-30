/**
 * 
 */
package com.JB.PageObjects;

import org.testng.annotations.Test;

import com.JB.Utilities.commonUtils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author jeyaram.baba
 *
 */
public class LoginPage {
	
	WebDriver driver;
	static commonUtils Util = new commonUtils();
	
	@FindBy(how=How.ID,using="usernameOrEmail") WebElement username;
	
	@FindBy(how=How.ID,using="password") WebElement password;
	
	@FindBy(how=How.XPATH,using ="//*[@id='primary']/div/main/div/div[1]/div/form/div/div[3]/button" ) WebElement click_Loginbutton;
	
	
		
public LoginPage(WebDriver driver)
{

	this.driver = driver; 
}
		
	public void type_username(String username1)
	{	
		Util.waitForElement(driver, username);
		username.sendKeys(username1);
	}
	
	public void type_password(String password1)
	{
		Util.waitForElement(driver, password);
		password.sendKeys(password1);
	}
	
	public void click_Loginbutton()
	{
		click_Loginbutton.click();
	}
	

}
