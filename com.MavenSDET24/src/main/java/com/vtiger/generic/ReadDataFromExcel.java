package com.vtiger.generic;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {
	public static String getexcelvalue(String sheet,int row,int column) throws Throwable  {
	FileInputStream fis =new FileInputStream("C:\\Users\\Manoj sd\\eclipse-workspace\\com.MavenSDET24\\src\\test\\resources\\commondata.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	String value = wb.getSheet(sheet).getRow(row).getCell(column).getStringCellValue();
	return value;
	
	
}
}