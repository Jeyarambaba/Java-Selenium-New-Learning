package com.JB.Utilities;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class Log 
{
	public static Logger logger = Logger.getLogger(Log.class);
		
	BrowserFactory BFact = new BrowserFactory();
	
	public Log()
	{
		PropertyConfigurator.configure(BFact.GetCurrentDirectory()+"\\Resources\\log4j.properties");
	}
	
	public void info(String message) 
		{
		logger.info(message);
	 	}
	public void warn(String message) 
		{
		logger.warn(message);
	 	}
	 public void error(String message) 
	 	{
		 logger.error(message);
	 	}
	  public void fatal(String message) {
		  logger.fatal(message);
	 	}
	  public void debug(String message) {
		  logger.debug(message);
	 	}	
}