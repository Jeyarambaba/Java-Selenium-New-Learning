/**
 * 
 */
package com.JB.Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author jeyaram.baba
 *
 */
public class BrowserFactory implements IGetCurrentDirectory
{
	
	public static WebDriver driver ;
	
	String currentDir = GetCurrentDirectory();
	
	public WebDriver OpenBrowser(String URL, String BrowserType)
	{
		if(BrowserType.contains("firefox"))
		{	
			System.setProperty("webdriver.gecko.driver",currentDir+"\\SeleniumDrivers\\geckodriver.exe");
		    driver = new FirefoxDriver();
		}
		
		if(BrowserType.contains("chrome"))
		{	
			ChromeOptions options = new ChromeOptions();
			DesiredCapabilities caps = DesiredCapabilities.chrome();
			caps.setCapability(ChromeOptions.CAPABILITY, options);
			System.setProperty("webdriver.chrome.driver", currentDir+"\\SeleniumDrivers\\chromedriver.exe");
		    driver = new ChromeDriver(caps);
		}
		
		if(BrowserType.contains("ie"))
		{
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability("EnableNativeEvents", false);
			caps.setCapability("ignoreZoomSetting", true);
			System.setProperty("webdriver.ie.driver",currentDir+"\\SeleniumDrivers\\IEDriverServer.exe");
		    driver = new InternetExplorerDriver(caps);
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		driver.manage().window().maximize();
		return driver;
	}
	
	
	public String GetCurrentDirectory()
	{
		String currentDir = System.getProperty("user.dir");
        System.out.println("Current dir using System:" +currentDir);
        return currentDir;
	}

}
