package com.page;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebElement;


import com.base.BasePage;

import com.utils.PageDriver;



public class FlightsPage extends BasePage {
	
	public FlightsPage(PageDriver driver){
		super(driver);
	}
	public PageDriver flightsPageDriver(String originCity,String destinationCity, Date departDate,Date returnDate){
		
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        
        
		//driver.navigateTo("https://www.kayak.com/flights");
		//driver.implicitWait();
		
		WebElement origin=driver.findElement("xpath-origin");
		origin.clear();
		origin.sendKeys(originCity);
		
		WebElement dest=driver.findElement("id-destination");
		dest.clear();
		dest.sendKeys(destinationCity);
		
		WebElement depart=driver.findElement("id-depart");
		depart.clear();
		depart.sendKeys(dateFormat.format(departDate));
	
		
		WebElement ret=driver.findElement("id-return");
		ret.clear();
		ret.sendKeys(dateFormat.format(returnDate));
		
		
		driver.findElement("id-searchButton").click();
		return driver;
	}
	
	public static String originText(PageDriver driver){
		WebElement originTitle=driver.findElement("xpath-originTitle");
		String text=originTitle.getText();
		return text;
	}
	
	public static String destinationText(PageDriver driver){
		WebElement destinationTitle=driver.findElement("xpath-destinationTitle");
		String destText=destinationTitle.getText();
		return destText;
	}
	
	public static boolean changeButton(PageDriver driver){
		boolean isChangeBtnPresent=false;
		WebElement changeBtn=driver.findElement("xpath-changeButton");
		if(changeBtn!=null){
			isChangeBtnPresent=true;
		}
		
		return isChangeBtnPresent;
	}
	
	
}
