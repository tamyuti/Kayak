package com.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.By;

public class Locators {

	public static HashMap<String,String> locator=new HashMap<String,String>();
	public static void loadLocator() throws IOException{
		try {
			FileReader reader=new FileReader("Locators.properties");
			Properties properties=new Properties();
			properties.load(reader);
			 Enumeration e = properties.propertyNames();
			  while(e.hasMoreElements())
			  {
				  String key = (String)e.nextElement();
				  String value = properties.getProperty(key);
				  locator.put(key, value);
			  }
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
	public static By get(String key)
	{
     
		if(key.contains("-"))
		{
			String[] value = key.split("-");
			if(value[0].equals("id"))
			{
				return By.id(locator.get(key));
			}
			else if(value[0].equals("name"))
			{
				return By.name(locator.get(key));
			}
			else if(value[0].equals("xpath"))
			{
				return By.xpath(locator.get(key));
			}
			else if(value[0].equals("class"))
			{
				return By.className(locator.get(key));
			}
			else if(value[0].equals("link"))
			{
				return By.linkText(locator.get(key));
			}
			else if(value[0].equals("partial"))
			{
				return By.partialLinkText(locator.get(key));
			}
			else if(value[0].equals("tag"))
			{
				return By.tagName(locator.get(key));
			}
			else
			{
				return By.cssSelector(locator.get(key));
			}
			
			

		}
		return By.cssSelector(locator.get(key));
		
		
	}
}
