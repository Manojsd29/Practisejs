package com.crmcontactTest;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.vtiger.generic.ExcelUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class createcontactTest {
	
@Test
	public  void createcontacttest() throws Throwable {
	Random ran =new Random();
	int ranweb = ran.nextInt(100);


		WebDriverManager.chromedriver().setup();
		//WebDriverManager.firefoxdriver().setup();
		ExcelUtility elib=new ExcelUtility();
		String un = elib.getExcelValue("Sheet1", 2, 1);
		String pwd = elib.getExcelValue("Sheet1", 2, 2);
		String browser = elib.getExcelValue("Sheet1", 2, 4);	
		String url = elib.getExcelValue("Sheet1", 2, 3);
		String lname=elib.getExcelValue("newcontact",2,0)+"_"+ranweb;
		String fname=elib.getExcelValue("newcontact",2,1)+"_"+ranweb;


		/*//Datas from the excel files(External Resource file)
		String un = ReadDataFromExcel.getexcelvalue("Sheet1", 2, 1);
		String pwd = ReadDataFromExcel.getexcelvalue("Sheet1", 2, 2);
		String browser = ReadDataFromExcel.getexcelvalue("Sheet1", 2, 4);
		String orgname = ReadDataFromExcel.getexcelvalue("createorg", 3, 2);
		 */

		//To Enter into the user defined browser.	
		WebDriverManager.chromedriver().setup();
		WebDriver driver;
		driver=null;
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//get to the url
		driver.get(url);
		//Enter the username
		driver.findElement(By.name("user_name")).sendKeys(un);
		//enter the password
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pwd);
		//enter the click button
		driver.findElement(By.id("submitButton")).click();
		
		//click on Contact module
		driver.findElement(By.linkText("Contacts")).click();
		//click on create new contact button
	     driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	     //Enter the first name
	     
	     driver.findElement(By.name("firstname")).sendKeys(fname);
	     
	     //Enter the last name
		driver.findElement(By.name("lastname")).sendKeys(lname);
		//click on save button
			driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
			//get the title from contact information page
			String title = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			//verify
			if(title.contains("Contact Information")) {
				System.out.println("Contact is created ==>>pass");
			}
			else {
				System.out.println("contact is not created =>>fail");
			}
			//Click on adminstration button
			driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
			//click on signout linktext
			driver.findElement(By.linkText("Sign Out")).click();
			//closing the vtiger aplication
			driver.close();
		
		
		
	}
}
