package com.test;

import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import com.base.BasePageTest;
import com.page.FlightsPage;


public class FlightsPageTest extends BasePageTest {
	FlightsPage fpg;
	
	
	@BeforeClass
	public void setUp(){
		fpg=new FlightsPage(driver);
		
	}
	
	@DataProvider(name="data")
	public Object[][] getDatas(){
		Object[][] d=excelData.getData();
		return d;
	}
	
	@Test(dataProvider="data",priority=1)
	public void dataMethod(String originCity,String destinationCity, Date departDate,Date returnDate){
	fpg.flightsPageDriver(originCity, destinationCity,departDate, returnDate);
	}

	@Test(priority=2)
	public void originTextTest(){
		String text="NYC";
		String actual=FlightsPage.originText(driver);
		Assert.assertEquals(actual, text);
	}
	
	@Test(priority=3)
	public void destinationTextTest(){
		String text="SFO";
		String actual=FlightsPage.destinationText(driver);
		Assert.assertEquals(actual, text);
	}
	
	@Test(priority=4)
	public void changeButtonTest(){
		Assert.assertTrue(FlightsPage.changeButton(driver));
	}
	
	
	
	
}
