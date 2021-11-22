package com.vtiger.generic;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author Manoj sd
 *
 */
public class ExcelUtility {
	/**
	 * 
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return data
	 * @throws Throwable
	 */
	public String getExcelValue(String sheetName,int row,int cell) throws Throwable {
		FileInputStream fis = new FileInputStream("C:\\Users\\Manoj sd\\eclipse-workspace\\com.MavenSDET24\\src\\test\\resources\\commondata.xlsx");
		Workbook wb =WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		return data;
		
		
	}
}
