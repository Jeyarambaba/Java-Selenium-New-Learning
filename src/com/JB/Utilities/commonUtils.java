package com.JB.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hwpf.usermodel.DateAndTime;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonUtils
{
	BrowserFactory BF = new BrowserFactory();
	
	public void TakeScreenShot(WebDriver driver) throws IOException 
	{
		String currentDir = BF.GetCurrentDirectory();
		long time = GetCurrentDateandTime();
		String Filepath = currentDir+"\\Screenshots\\"+time+".jpeg";
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(Filepath)); 
	}
	
	public long GetCurrentDateandTime()
	{
		Calendar calendar = Calendar.getInstance();    
		calendar.set(Calendar.MILLISECOND, 0); // Clear the millis part. Silly API.
		calendar.set(2010, 8, 14, 0, 0, 0); // Note that months are 0-based
		Date date = calendar.getTime();
		long millis = date.getTime();
		return millis;
	}

	public void waitForElement(WebDriver driver, WebElement element) {
	    WebDriverWait wait = new WebDriverWait(driver,30);
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
