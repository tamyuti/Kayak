package com.base;

import java.io.IOException;

import org.testng.annotations.BeforeSuite;

import com.utils.Configuration;
import com.utils.ExcelData;
import com.utils.Locators;
import com.utils.PageDriver;

public abstract class BasePageTest {
	public PageDriver driver;
	
	public static Configuration config;
	public ExcelData excelData;
	static
	{

		try {
			config = new Configuration();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 

	@BeforeSuite
	public void setup() throws IOException
	{
		driver = new PageDriver(config);
		Locators.loadLocator();
		excelData=new ExcelData();
		
	}

}
