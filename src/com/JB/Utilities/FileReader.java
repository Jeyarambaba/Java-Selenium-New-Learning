/**
 * 
 */
package com.JB.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.gargoylesoftware.htmlunit.javascript.host.Iterator;


/**
 * @author jeyaram.baba
 *
 */
public class FileReader {
	
	public String PropertyFileReader(String value)
	{
		Properties prop = new Properties();
		BrowserFactory BF = new BrowserFactory();
		String FileLocation = (BF.GetCurrentDirectory()+"\\Resources\\config.properties");
		  
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(FileLocation);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop.getProperty(value);
	}
	
	
	public void XMLReader()
	{
		
	}
	
	public String XLReader(String sheetname, int row, int column) throws IOException
	{
		BrowserFactory BF = new BrowserFactory();
		String FileLocation = (BF.GetCurrentDirectory()+"\\Resources\\TestData.xlsx");
		 File source = new File(FileLocation);
		  FileInputStream FIS = new FileInputStream(source);
		  XSSFWorkbook wb=new XSSFWorkbook(FIS);
		  XSSFSheet sheet = wb.getSheet(sheetname);
		  //Iterator rows = (Iterator) sheet.rowIterator();
		  String data = sheet.getRow(row).getCell(column).getStringCellValue();
		  System.out.println("The data is: "+data);
		  return data;
	}
	
	
	
	public void XLWriter()
	{
		
	}

}
