package com.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class PageDriver {
	private WebDriver driver;
	Configuration config;

	public PageDriver(Configuration config){
		this.config=config;
		start();
	}

	public void start(){
		String browser=config.browser;
		switch(browser)
		{
		case "firefox": 
			driver=startFirefox();
			break;
		case "chrome":
			driver=startChrome();
			break;

		case "ie":
			driver=startIE();
			break;
		default:
			driver=startHtml();
			break;
		}
		driver.get(config.url);
	}




	private WebDriver startFirefox(){
		return new FirefoxDriver();
	}
	private WebDriver startChrome(){
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		return new ChromeDriver();
	}
	private WebDriver startIE(){
		System.setProperty("webdriver.ie.driver", "lib/IEDriverServer.exe");
		return new InternetExplorerDriver();
	}
	private WebDriver startHtml() {
		return  new HtmlUnitDriver();
	}

	public WebElement findElement(String locator){
		WebElement element=driver.findElement(Locators.get(locator));
		return element;
	}
	
	public void navigateTo(String s){
		driver.navigate().to(s);
	}
	
	public void implicitWait(){
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	}
	

}

