package com.vtiger.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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
		FileInputStream fis = new FileInputStream("C:\\Users\\Manoj sd\\Desktop\\Recordings\\Selenium\\selenium\\commondata.xlsx‪");
		Workbook wb =WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		System.out.println(data);
		return data;
		
	}
	
//	public static void main(String[] args) throws Throwable, IOException {
//		FileInputStream fis =new FileInputStream("C:\\Users\\Manoj sd\\Desktop\\Recordings\\Selenium\\selenium\\commondata.xlsx");
//		Workbook wb=WorkbookFactory.create(fis);
//		String data=wb.getSheet("createorg").getRow(3).getCell(1).getStringCellValue();
//		System.out.println(data);		
//	}
	
	
	}

