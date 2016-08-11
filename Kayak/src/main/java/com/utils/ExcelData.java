package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	public Object[][] getData(){
		Object[][] data;
	try {
		XSSFWorkbook book = new XSSFWorkbook(new FileInputStream(new File("Flights.xlsx")));
		Sheet sheet = book.getSheetAt(0);
		int numberOfRows = sheet.getLastRowNum();
		data = new Object[numberOfRows+1][4];
		Iterator<Row> rows = sheet.iterator();
		int i = 0;
		while(rows.hasNext())
		{
			int j = 0;
			Row row = rows.next();
			Iterator<Cell> cells = row.cellIterator();
			while(cells.hasNext())
			{
				Cell cell = cells.next();
				if(j>1){
					data[i][j]=cell.getDateCellValue();
				}
				else{
				data[i][j] = cell.getStringCellValue();
				}
				j++;
			}
			i++;
		}
		
		
		book.close();
		return data;
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}

}
