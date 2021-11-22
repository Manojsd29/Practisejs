package com.crmOrganisationTest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.vtiger.generic.ReadDataFromExcel;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOraganizationWithIndustriesTest {
	@Test
	public void createIndustries() throws Throwable {
		
	WebDriverManager.chromedriver().setup();
	//WebDriverManager.firefoxdriver().setup();
	//Datas from the excel files(External Resource file)
	Random r =new Random();
	int ran = r.nextInt(500);
	
	String un = ReadDataFromExcel.getexcelvalue("Sheet1", 2, 1);
	String pwd = ReadDataFromExcel.getexcelvalue("Sheet1", 2, 2);
	String browser = ReadDataFromExcel.getexcelvalue("Sheet1", 2, 4);
	String orgname = ReadDataFromExcel.getexcelvalue("createorg", 3, 2)+"_"+ran;
	
	//To Enter into the user defined browser.	
	WebDriver driver;
	driver=null;
	if(browser.equals("chrome")) {
		
		driver=new ChromeDriver();
	}
	else if(browser.equals("firefox")) {
		
		driver=new FirefoxDriver();
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//get to the url
	driver.get("http://localhost:8888/");
	//Enter the username
	driver.findElement(By.name("user_name")).sendKeys(un);
	//enter the password
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pwd);
	//enter the click button
	driver.findElement(By.id("submitButton")).click();
	//click on organization module
	driver.findElement(By.linkText("Organizations")).click();
	//click on create organization button
     driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
//Enter the Organization name
driver.findElement(By.name("accountname")).sendKeys(orgname);
//select the  industries
driver.findElement(By.name("industry")).click();
WebElement indus = driver.findElement(By.name("industry"));

Select select =new Select( indus);
select.selectByVisibleText("Energy");
//select the type
driver.findElement(By.name("accounttype")).click();
WebElement type = driver.findElement(By.name("accounttype"));
Select set1 =new Select(type);
set1.selectByVisibleText("Press");
//click on save button
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//verification
 String text = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(text.contains("Organization Information")) {
		System.out.println("Organization is created===>>pass");
	}
	else {
		System.out.println("Organization not created==>>fail");
		
	}




}

}

