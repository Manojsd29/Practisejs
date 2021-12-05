package com.vtiger.generic;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {
	/**
	 * Get the data from property file
	 * @param key
	 * @return value
	 * @throws Throwable
	 */
public String getvalues(String key) throws Throwable {
	FileInputStream fis =new FileInputStream("C:\\Users\\Manoj sd\\Desktop\\Recordings\\Selenium\\selenium\\commondata1.property.txt");
	Properties p =new Properties();
	p.load(fis);
	String value = p.getProperty(key);
	return value;
	
	
	
}
/**
 * Get the data from excel sheet
 * @param sheetName
 * @param row
 * @param cell
 * @return data					
 * @throws Throwable
 */

//public String getExcelValue(String sheetName,int row,int cell) throws Throwable {
//	FileInputStream fis = new FileInputStream("C:\\Users\\Manoj sd\\Desktop\\Recordings\\Selenium\\selenium\\commondata.xlsx");
//	Workbook wb =WorkbookFactory.create(fis);
//	String data = wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
//	return data;
//	
//}
}
