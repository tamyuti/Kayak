package com.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
	public String browser;
	public String url;
	
	public Configuration() throws IOException{
		try {
			FileReader reader=new FileReader("config.properties");
			Properties prop=new Properties();
			prop.load(reader);
			browser=prop.getProperty("browser");
			url=prop.getProperty("url");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	

}
